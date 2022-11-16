package com.ssafy.home.board.dto;

public class BoardDTO {
	private int bno;
	private String user_id;
	private String title;
	private String content;
	private int hit;
	private String regtime;
	private String sido;
	private String gugun;

	public BoardDTO() {
	}

	public BoardDTO(int bno, String user_id, String title, String content, int hit, String regtime, String sido,
			String gugun) {
		this.bno = bno;
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.regtime = regtime;
		this.sido = sido;
		this.gugun = gugun;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", user_id=" + user_id + ", title=" + title + ", content=" + content + ", hit="
				+ hit + ", regtime=" + regtime + ", sido=" + sido + ", gugun=" + gugun + "]";
	}

}
