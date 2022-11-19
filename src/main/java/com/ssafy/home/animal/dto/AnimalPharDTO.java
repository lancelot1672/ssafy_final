package com.ssafy.home.animal.dto;

public class AnimalPharDTO {
	private int no;
	private String name;
	private String street_addr; // 도로명
	private String site_addr; // 지번
	private String lat;
	private String lng;
	private double dis;

	public AnimalPharDTO() {
	}

	public AnimalPharDTO(int no, String name, String street_addr, String site_addr, String lat, String lng,
			double dis) {
		this.no = no;
		this.name = name;
		this.street_addr = street_addr;
		this.site_addr = site_addr;
		this.lat = lat;
		this.lng = lng;
		this.dis = dis;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet_addr() {
		return street_addr;
	}

	public void setStreet_addr(String street_addr) {
		this.street_addr = street_addr;
	}

	public String getSite_addr() {
		return site_addr;
	}

	public void setSite_addr(String site_addr) {
		this.site_addr = site_addr;
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
		return "AnimalHosDTO [no=" + no + ", name=" + name + ", street_addr=" + street_addr + ", site_addr=" + site_addr
				+ ", lat=" + lat + ", lng=" + lng + ", dis=" + dis + "]";
	}

}
