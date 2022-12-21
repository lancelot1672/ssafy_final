package com.ssafy.home.apt.dto;

public class AptLikeDTO {
    private int no;
    private String userId;
    private long houseCode;

    public AptLikeDTO(int no, String userId, long houseCode) {
        this.no = no;
        this.userId = userId;
        this.houseCode = houseCode;
    }
    public AptLikeDTO() {

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(long houseCode) {
        this.houseCode = houseCode;
    }

    @Override
    public String toString() {
        return "AptListDTO{" +
                "no=" + no +
                ", userId='" + userId + '\'' +
                ", houseCode=" + houseCode +
                '}';
    }
}
