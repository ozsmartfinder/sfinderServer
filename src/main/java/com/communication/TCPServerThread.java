package com.communication;

import java.io.*;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.data.DeviceInfo;
import com.hibernate.data.DeviceInfoHistory;
import com.positioning.GPSDatum;
import com.positioning.GPSDatumFactory;

public class TCPServerThread extends Thread {

    Socket socket = null;
    GPSDatumFactory gDF = new GPSDatumFactory();
    SessionFactory sF = new Configuration().configure().buildSessionFactory();

    public TCPServerThread(Socket socket) {
        this.socket = socket;
    }
    
    private void saveGPSDatum(String info, int type) {
    	GPSDatum gD = gDF.getGPSDatum(info, type);
    	Map<String, String> GPSDataMap = gD.getGPSInfo();
    	
    	DeviceInfo dI = new DeviceInfo();
		dI.setDevId(GPSDataMap.get("DevId"));
		dI.setLon(Double.parseDouble(GPSDataMap.get("Lon"))*0.01);
		dI.setLat(Double.parseDouble(GPSDataMap.get("Lat"))*0.01);
		dI.setApt(Double.parseDouble(GPSDataMap.get("Apt")) * 0.01);
		
		DeviceInfoHistory dIH = new DeviceInfoHistory();
		dIH.setDevId(GPSDataMap.get("DevId"));
		dIH.setLon(Double.parseDouble(GPSDataMap.get("Lon"))*0.01);
		dIH.setLat(Double.parseDouble(GPSDataMap.get("Lat"))*0.01);
		dIH.setApt(Double.parseDouble(GPSDataMap.get("Apt")) * 0.01);
		
		long currTime = System.currentTimeMillis();  
		Timestamp timeObj = new Timestamp(currTime); 
		dI.setTime(timeObj);
		
		Session session = sF.openSession();
		session.beginTransaction();
		session.saveOrUpdate(dI);
		session.getTransaction().commit();
		
		session.beginTransaction();
		session.saveOrUpdate(dIH);
		session.getTransaction().commit();
		
		session.close();
    }

    //thread operations, response to the request
    @Override
	public void run() {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            //get input stream, get client's information
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info = null;
            while ((info = br.readLine()) != null) {
            	//loop to get client's message
            	saveGPSDatum(info, 1);        	
            }
            socket.shutdownInput();  //close the input stream

            //get output stream, response to client's request
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("Finish Transimission, Closed !");
            //call flush
            pw.flush();
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close the resource
            try {
                if (pw != null)
                    pw.close();
                if (os != null)
                    os.close();
                if (br != null)
                    br.close();
                if (isr != null)
                    isr.close();
                if (is != null)
                    is.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
