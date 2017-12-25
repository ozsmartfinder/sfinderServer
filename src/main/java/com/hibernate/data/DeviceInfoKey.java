package com.hibernate.data;

import java.io.Serializable;

public class DeviceInfoKey implements Serializable {
	
	private static final long serialVersionUID = 3176972128965536016L;
	
	private int Id;
	private String DevId;
	
	public DeviceInfoKey() {
		
	}
	
	public DeviceInfoKey(int Id, String DevId) {  
	    this.Id = Id; 
	    this.DevId = DevId;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDevId() {
		return DevId;
	}

	public void setDevId(String devId) {
		DevId = devId;
	}
	
}
