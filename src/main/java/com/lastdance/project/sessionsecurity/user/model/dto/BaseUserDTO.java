package com.lastdance.project.sessionsecurity.user.model.dto;

public class BaseUserDTO {
    private int memberNo; // primary key
    private String userId;
    private String userName;
    private String userPass;
    private String role; // STUDENT, TEACHER, ADMIN


    public BaseUserDTO() {
    }

    public BaseUserDTO(int memberNo, String userId, String userName, String userPass, String role) {
        this.memberNo = memberNo;
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.role = role;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "BaseUserDTO{" +
                "memberNo=" + memberNo +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}