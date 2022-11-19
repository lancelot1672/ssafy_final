package com.ssafy.home.animal.dto;

public class AnimalHosDTO {
    private int no;
    private String name;
    private String streetAddress;   // 도로명
    private String siteAddress; //지번
    private String lat;
    private String lng;

    public AnimalHosDTO(int no, String name, String streetAddress, String siteAddress, String lat, String lng) {
        this.no = no;
        this.name = name;
        this.streetAddress = streetAddress;
        this.siteAddress = siteAddress;
        this.lat = lat;
        this.lng = lng;
    }

    public AnimalHosDTO() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
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

    @Override
    public String toString() {
        return "AnimalHosDTO{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", siteAddress='" + siteAddress + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
