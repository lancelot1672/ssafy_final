package com.ssafy.home.station.dto;

public class BikeDTO {
	private int rent_id;
	private String rent_name;
	private String address1;
	private String address2;
	private String lat;
	private String lng;
	private double dis;

	public BikeDTO() {
	}

	public BikeDTO(int rent_id, String rent_name, String address1, String address2, String lat, String lng,
			double dis) {
		this.rent_id = rent_id;
		this.rent_name = rent_name;
		this.address1 = address1;
		this.address2 = address2;
		this.lat = lat;
		this.lng = lng;
		this.dis = dis;
	}

	public int getRent_id() {
		return rent_id;
	}

	public void setRent_id(int rent_id) {
		this.rent_id = rent_id;
	}

	public String getRent_name() {
		return rent_name;
	}

	public void setRent_name(String rent_name) {
		this.rent_name = rent_name;
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

	public double getDis() {
		return dis;
	}

	public void setDis(double dis) {
		this.dis = dis;
	}

	@Override
	public String toString() {
		return "BikeDTO [rent_id=" + rent_id + ", rent_name=" + rent_name + ", address1=" + address1 + ", address2="
				+ address2 + ", lat=" + lat + ", lng=" + lng + ", dis=" + dis + "]";
	}

}
