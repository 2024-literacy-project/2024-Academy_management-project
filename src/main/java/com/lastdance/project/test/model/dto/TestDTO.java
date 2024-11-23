package com.lastdance.project.test.model.dto;

import java.util.Date;

public class TestDTO {

    private int member_no;
    private String member_name;
    private String member_id;
    private String member_password;
    private Enum member_role_type;
    private Date birth_date;
    private String phone;
    private String address;
    private Date enroll_date;

    public TestDTO() {
    }

    public TestDTO(int member_no, String member_name, String member_id, String member_password, Enum member_role_type, Date birth_date, String phone, String address, Date enroll_date) {
        this.member_no = member_no;
        this.member_name = member_name;
        this.member_id = member_id;
        this.member_password = member_password;
        this.member_role_type = member_role_type;
        this.birth_date = birth_date;
        this.phone = phone;
        this.address = address;
        this.enroll_date = enroll_date;
    }

    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_password() {
        return member_password;
    }

    public void setMember_password(String member_password) {
        this.member_password = member_password;
    }

    public Enum getMember_role_type() {
        return member_role_type;
    }

    public void setMember_role_type(Enum member_role_type) {
        this.member_role_type = member_role_type;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEnroll_date() {
        return enroll_date;
    }

    public void setEnroll_date(Date enroll_date) {
        this.enroll_date = enroll_date;
    }

    @Override
    public String toString() {
        return "TestDTO{" +
                "member_no=" + member_no +
                ", member_name='" + member_name + '\'' +
                ", member_id='" + member_id + '\'' +
                ", member_password='" + member_password + '\'' +
                ", member_role_type=" + member_role_type +
                ", birth_date=" + birth_date +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", enroll_date=" + enroll_date +
                '}';
    }
}
