package com.capgemini.pojo;

public class Address {
	//private String empId;
	private String city;
	private String state;
	private String pincode;
	public Address( String city, String state, String pincode) {
		super();
		//this.empId = empId;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	/*public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}*/
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", pincode="
				+ pincode + "]";
	}
	
}
