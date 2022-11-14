package com.ssafy.home.apt.dto;

public class SidocodeDTO {

	private String sidoCode;
	private String sidoName;

	public SidocodeDTO() {
	}

	public SidocodeDTO(String sidoCode, String sidoName) {
		this.sidoCode = sidoCode;
		this.sidoName = sidoName;
	}

	public String getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(String sidoCode) {
		this.sidoCode = sidoCode;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

	@Override
	public String toString() {
		return "SidocodeDTO [sidoCode=" + sidoCode + ", sidoName=" + sidoName + "]";
	}

}