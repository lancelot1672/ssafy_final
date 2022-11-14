package com.ssafy.home.apt.dto;


public class GuguncodeDTO {
	private String gugunCode;
	private String gugunName;

	public GuguncodeDTO() {
	}

	public GuguncodeDTO(String gugunCode, String gugunName) {
		this.gugunCode = gugunCode;
		this.gugunName = gugunName;
	}

	public String getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(String gugunCode) {
		this.gugunCode = gugunCode;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	@Override
	public String toString() {
		return "GuguncodeDTO [gugunCode=" + gugunCode + ", gugunName=" + gugunName + "]";
	}

}