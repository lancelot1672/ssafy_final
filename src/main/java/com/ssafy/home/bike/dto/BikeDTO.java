package com.ssafy.home.bike.dto;

public class BikeDTO {
	private int rentId;
	private String location;
	private String rentName;
	private String address1;
	private String address2;
	private String lat;
	private String lng;
	
	public BikeDTO(int rentId, String location, String rentName, String address1, String address2, String lat,
			String lng) {
		this.rentId = rentId;
		this.location = location;
		this.rentName = rentName;
		this.address1 = address1;
		this.address2 = address2;
		this.lat = lat;
		this.lng = lng;
	}

	public BikeDTO() {
	}

	public int getRentId() {
		return rentId;
	}

	public void setRentId(int rentId) {
		this.rentId = rentId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRentName() {
		return rentName;
	}

	public void setRentName(String rentName) {
		this.rentName = rentName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "BikeDTO [rentId=" + rentId + ", location=" + location + ", rentName=" + rentName + ", address1="
				+ address1 + ", address2=" + address2 + ", lat=" + lat + ", lng=" + lng + "]";
	}

	
}
