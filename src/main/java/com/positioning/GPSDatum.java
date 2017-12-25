package com.positioning;

import java.util.HashMap;
import java.util.Map;

public interface GPSDatum {
	public Map<String, String> getGPSInfo();
}

class GPSDatum_Secumore_G03 implements GPSDatum {
	private String _datum;
	public GPSDatum_Secumore_G03(String datum) {
		_datum = datum;
	}
	
	public Map<String, String> getGPSInfo(){
		String[] stringArray = this._datum.split(",");
		Map<String, String> DataMap = new HashMap<String, String>();
		DataMap.put("DevId", stringArray[1]);
		DataMap.put("Apt", stringArray[3]);
		DataMap.put("Lat", stringArray[6].equals('S') ? "-":"" + stringArray[5]);  //jingdu
		DataMap.put("Lon", stringArray[8].equals('E') ? "":"-" + stringArray[7]);  //weidu
		return DataMap;
	}
}

class GPSDatum_Ublox_C030 implements GPSDatum {
	public GPSDatum_Ublox_C030() {
		
	}
	
	public Map<String, String> getGPSInfo() {
		return null;
	}
}

class GPSDatum_SQUAD_ARDUINO implements GPSDatum {
	public GPSDatum_SQUAD_ARDUINO() {
		
	}
	
	public Map<String, String> getGPSInfo() {
		return null;
	}
}
