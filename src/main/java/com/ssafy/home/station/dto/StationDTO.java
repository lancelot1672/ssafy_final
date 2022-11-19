package com.ssafy.home.station.dto;

public class StationDTO {
	private String line;
	private String name;
	private String code;
	private String lat;
	private String lng;
	private double distance;

	public StationDTO() {
	}

	public StationDTO(String line, String name, String code, String lat, String lng, double distance) {
		super();
		this.line = line;
		this.name = name;
		this.code = code;
		this.lat = lat;
		this.lng = lng;
		this.distance = distance;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "StationDTO [line=" + line + ", name=" + name + ", code=" + code + ", lat=" + lat + ", lng=" + lng
				+ ", distance=" + distance + "]";
	}

}
