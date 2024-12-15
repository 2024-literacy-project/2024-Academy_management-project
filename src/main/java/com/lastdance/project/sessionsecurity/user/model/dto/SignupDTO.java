package com.lastdance.project.sessionsecurity.user.model.dto;

import java.time.LocalDate;

public class SignupDTO {
    private int memberNo; // AUTO_INCREMENT로 생성된 값
    private String userName;

    private String userId;

    private String userPass;

    private String role;

    private LocalDate birth;

    private String phone;

    private String address;

    private LocalDate registrationDate;

    private StudentDTO studentDTO;

    public SignupDTO() {
    }


    public SignupDTO(int memberNo, String userName, String userId, String userPass, String role, LocalDate birth, String phone, String address, LocalDate registrationDate, StudentDTO studentDTO) {
        this.memberNo = memberNo;
        this.userName = userName;
        this.userId = userId;
        this.userPass = userPass;
        this.role = role;
        this.birth = birth;
        this.phone = phone;
        this.address = address;
        this.registrationDate = registrationDate;
        this.studentDTO = studentDTO;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    @Override
    public String toString() {
        return "SignupDTO{" +
                "memberNo=" + memberNo +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", userPass='" + userPass + '\'' +
                ", role='" + role + '\'' +
                ", birth=" + birth +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", registrationDate=" + registrationDate +
                ", studentDTO=" + studentDTO +
                '}';
    }
}
