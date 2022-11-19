package com.ssafy.home.member.dto;

public class MemberDto {
    private String userId;
    private String userPw;
    private String userName;
    private String phone;
    private int age;

    public MemberDto(String userId, String userPw, String userName, String phone, int age) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.phone = phone;
        this.age = age;
    }

    public MemberDto() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "userId='" + userId + '\'' +
                ", userPw='" + userPw + '\'' +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }
}
