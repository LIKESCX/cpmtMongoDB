package com.example.demo.dto;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private static final long serialVersionUID = -429972725594758869L;
	private String id;
	private String probMac;
	private String devcMac;
	private String inTime;
	private String outTime;
	private String rssi;
	
	public Customer( String probMac, String devcMac, String inTime, String outTime, String rssi) {
		this.probMac = probMac;
		this.devcMac = devcMac;
		this.inTime = inTime;
		this.outTime = outTime;
		this.rssi = rssi;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProbMac() {
		return probMac;
	}

	public void setProbMac(String probMac) {
		this.probMac = probMac;
	}

	public String getDevcMac() {
		return devcMac;
	}

	public void setDevcMac(String devcMac) {
		this.devcMac = devcMac;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getRssi() {
		return rssi;
	}

	public void setRssi(String rssi) {
		this.rssi = rssi;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", probMac=" + probMac + ", devcMac=" + devcMac + ", inTime=" + inTime
				+ ", outTime=" + outTime + ", rssi=" + rssi + "]";
	}
	
}
