package com.htc.springjpausinghibernate.entity;

public class Address {
	private int doorNo;
	private String streetName;
	private String city;
	private int pincode;
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Address(int doorNo, String streetName, String city, int pincode) {
		super();
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.city = city;
		this.pincode = pincode;
	}

	
	public int getDoorNo() {
		return doorNo;
	}


	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}


	public String getStreetName() {
		return streetName;
	}


	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", streetName=" + streetName + ", city=" + city + ", pincode=" + pincode
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + doorNo;
		result = prime * result + pincode;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (doorNo != other.doorNo)
			return false;
		if (pincode != other.pincode)
			return false;
		return true;
	}
	
	
}
