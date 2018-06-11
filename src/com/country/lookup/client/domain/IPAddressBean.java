package com.country.lookup.client.domain;

/**
 * Bean class to hold each line item from test data 
 *
 */
public class IPAddressBean implements Comparable<IPAddressBean> {
	
	private String ipAddress;
	private String companyName;
	private String result;
	
	public IPAddressBean(String ipAddress, String companyName) {
		this.ipAddress = ipAddress;
		this.companyName = companyName;
	}
	
	
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	@Override
	public int compareTo(IPAddressBean other) {
		if (other == null) {
			return 1; // means this > other
		}
		
		if (this.getCompanyName() == null && other.getCompanyName() == null) {
			return 0; // means this == other
		}
		
		if (this.getCompanyName() == null) {
			return -1; // means this < other
		}
		
		return this.getCompanyName().compareTo(other.getCompanyName());
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		if (this.getResult()!=null && !this.getResult().equalsIgnoreCase("Not Found")) {
			result.append("> " + this.getCompanyName() + " ["+this.getIpAddress()+"] belongs to country: " + this.getResult());
		}
		
		else {
			result.append("> " + this.getCompanyName() + " ["+this.getIpAddress()+"] do not belong to any country");
			
		}
		return result.toString();
	}
	

}
