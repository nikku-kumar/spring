package com.tap.pojo;

public class Address {
	

	private int laneNo;
	private String city;
	private String state;
	private String country;
	
	public Address() {
		
	}

	public Address(int laneNo, String city, String state, String country) {
		super();
		this.laneNo = laneNo;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public int getLaneNo() {
		return laneNo;
	}

	public void setLaneNo(int laneNo) {
		this.laneNo = laneNo;
	}

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		
		return laneNo+" "+city+" "+state+" "+country;
	}
   


}
