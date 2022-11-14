package com.ssafy.home.apt.dto;

public class HouseListDTO {
	private String dongCode;
	private String dongName;
	private int dealYear;
	private int dealMonth;
	
	
	public HouseListDTO() {

	}
	public HouseListDTO(String dongCode, String dongName, int dealYear, int dealMonth) {

		this.dongCode = dongCode;
		this.dongName = dongName;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public String getDongName() {
		return dongName;
	}
	public void setDongName(String dongName) {
		this.dongName = dongName;
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
	@Override
	public String toString() {
		return "HouseListDTO [dongCode=" + dongCode + ", dongName=" + dongName + ", dealYear=" + dealYear
				+ ", dealMonth=" + dealMonth + "]";
	}


}
