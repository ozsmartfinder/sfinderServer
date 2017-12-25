package com.communication;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	
	public TCPServer() {
		
	}
	
	public void runServer() {
		try {
            //create socket and bind the port
            ServerSocket serverSocket=new ServerSocket(8088);
            Socket socket=null;

            //record client number
            int count=0;
            System.out.println("Server Started, wait for clients !");

            //loop listen and wait for client
            while(true){
                //call accept to start listen, wait for connection
                socket=serverSocket.accept();

                //create a new thread
                TCPServerThread serverThread=new TCPServerThread(socket);
                //initial thread
                serverThread.start();

                //count how many clients
                count++;
                System.out.println("Number of Clients："+count);
                InetAddress address=socket.getInetAddress();
                System.out.println("Client's IP："+address.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

}
