package com.ssafy.home.bus.dto;

public class BusDTO {
	private String stop_nm;
	private String ycode;
	private String stop_no;
	private String xcode;
	public BusDTO() {}
	public BusDTO(String stop_nm, String ycode, String stop_no, String xcode) {
		this.stop_nm = stop_nm;
		this.ycode = ycode;
		this.stop_no = stop_no;
		this.xcode = xcode;
	}

	public String getStop_nm() {
		return stop_nm;
	}

	public void setStop_nm(String stop_nm) {
		this.stop_nm = stop_nm;
	}

	public String getYcode() {
		return ycode;
	}

	public void setYcode(String ycode) {
		this.ycode = ycode;
	}

	public String getStop_no() {
		return stop_no;
	}

	public void setStop_no(String stop_no) {
		this.stop_no = stop_no;
	}

	public String getXcode() {
		return xcode;
	}

	public void setXcode(String xcode) {
		this.xcode = xcode;
	}

	@Override
	public String toString() {
		return "BusDTO [stop_nm=" + stop_nm + ", ycode=" + ycode + ", stop_no=" + stop_no + ", xcode=" + xcode + "]";
	}
	
	
	
}
