package com.ssafy.home.station.dto;

import java.util.List;

public class AptStationDTO {

	private String apartmentName;
	private String dongName;
	private String aptCode;
	private String buildYear;
	private String roadName;
	private String jibun;
	private String lat;
	private String lng;
	private List<StationDTO> stationList;
	private List<BusDTO> busList;
	private List<BikeDTO> bikeList;

	public AptStationDTO() {
	}

	public AptStationDTO(String apartmentName, String dongName, String aptCode, String buildYear, String roadName,
			String jibun, String lat, String lng, List<StationDTO> stationList, List<BusDTO> busList,
			List<BikeDTO> bikeList) {
		this.apartmentName = apartmentName;
		this.dongName = dongName;
		this.aptCode = aptCode;
		this.buildYear = buildYear;
		this.roadName = roadName;
		this.jibun = jibun;
		this.lat = lat;
		this.lng = lng;
		this.stationList = stationList;
		this.busList = busList;
		this.bikeList = bikeList;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
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

	public List<StationDTO> getStationList() {
		return stationList;
	}

	public void setStationList(List<StationDTO> stationList) {
		this.stationList = stationList;
	}

	public List<BusDTO> getBusList() {
		return busList;
	}

	public void setBusList(List<BusDTO> busList) {
		this.busList = busList;
	}

	public List<BikeDTO> getBikeList() {
		return bikeList;
	}

	public void setBikeList(List<BikeDTO> bikeList) {
		this.bikeList = bikeList;
	}

	@Override
	public String toString() {
		return "AptStationDTO [apartmentName=" + apartmentName + ", dongName=" + dongName + ", aptCode=" + aptCode
				+ ", buildYear=" + buildYear + ", roadName=" + roadName + ", jibun=" + jibun + ", lat=" + lat + ", lng="
				+ lng + ", stationList=" + stationList + ", busList=" + busList + ", bikeList=" + bikeList + "]";
	}

}
