package com.ssafy.home.animal.dto;

import java.util.List;

public class AptAnimalDTO {
	private String apartmentName;
	private String dongName;
	private String aptCode;
	private String buildYear;
	private String roadName;
	private String jibun;
	private String lat;
	private String lng;
	private List<AnimalHosDTO> animalHosList;
	private List<AnimalPharDTO> animalPharList;

	public AptAnimalDTO() {
	}

	public AptAnimalDTO(String apartmentName, String dongName, String aptCode, String buildYear, String roadName,
			String jibun, String lat, String lng, List<AnimalHosDTO> animalHosList,
			List<AnimalPharDTO> animalPharList) {
		this.apartmentName = apartmentName;
		this.dongName = dongName;
		this.aptCode = aptCode;
		this.buildYear = buildYear;
		this.roadName = roadName;
		this.jibun = jibun;
		this.lat = lat;
		this.lng = lng;
		this.animalHosList = animalHosList;
		this.animalPharList = animalPharList;
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

	public List<AnimalHosDTO> getAnimalHosList() {
		return animalHosList;
	}

	public void setAnimalHosList(List<AnimalHosDTO> animalHosList) {
		this.animalHosList = animalHosList;
	}

	public List<AnimalPharDTO> getAnimalPharList() {
		return animalPharList;
	}

	public void setAnimalPharList(List<AnimalPharDTO> animalPharList) {
		this.animalPharList = animalPharList;
	}

	@Override
	public String toString() {
		return "AptAnimalDTO [apartmentName=" + apartmentName + ", dongName=" + dongName + ", aptCode=" + aptCode
				+ ", buildYear=" + buildYear + ", roadName=" + roadName + ", jibun=" + jibun + ", lat=" + lat + ", lng="
				+ lng + ", animalHosList=" + animalHosList + ", animalPharList=" + animalPharList + "]";
	}

}
