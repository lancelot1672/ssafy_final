package com.ssafy.home.apt.dto;

public class HousedealinfoDTO {
	private long no;
    private String apartmentName;
    private String floor;
    private String area;
    private String dongName;
    private String dealAmount;
    private String lat;
    private String lng;
    private int dealYear;
    private int dealMonth;
    private String aptCode;
    private String buildYear;
    private String roadName;
    private String jibun;
	public HousedealinfoDTO() {	}

	public HousedealinfoDTO(long no, String apartmentName, String floor, String area, String dongName, String dealAmount, String lat, String lng, int dealYear, int dealMonth, String aptCode, String buildYear, String roadName, String jibun) {
		this.no = no;
		this.apartmentName = apartmentName;
		this.floor = floor;
		this.area = area;
		this.dongName = dongName;
		this.dealAmount = dealAmount;
		this.lat = lat;
		this.lng = lng;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.aptCode = aptCode;
		this.buildYear = buildYear;
		this.roadName = roadName;
		this.jibun = jibun;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDongName() {
		return dongName;
	}
	public void setDongName(String dongName) {
		this.dongName = dongName;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
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
	public int getDealYear() {
		return dealYear;
	}
	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}
	public int getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}
	public String getAptCode() {
		return aptCode;
	}
	public void setAptCode(String aptCode) {
		this.aptCode = aptCode;
	}
	public String getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}


}
