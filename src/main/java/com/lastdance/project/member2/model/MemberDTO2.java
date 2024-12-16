package com.lastdance.project.member2.model;

import java.util.Date;

public class MemberDTO2 {

    private int member_no;
    private String name;
    private String id;
    private String password;
    private String role_type;
    private Date birth_date;
    private String phone;
    private String address;
    private Date enroll_date;

    //학생 정보
    private String school;
    private int grade;
    private String parent_contact;

    public MemberDTO2() {
    }

    public MemberDTO2(int member_no, String name, String id, String password, String role_type, Date birth_date, String phone, String address, Date enroll_date, String school, int grade, String parent_contact) {
        this.member_no = member_no;
        this.name = name;
        this.id = id;
        this.password = password;
        this.role_type = role_type;
        this.birth_date = birth_date;
        this.phone = phone;
        this.address = address;
        this.enroll_date = enroll_date;
        this.school = school;
        this.grade = grade;
        this.parent_contact = parent_contact;
    }

    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole_type() {
        return role_type;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getParent_contact() {
        return parent_contact;
    }

    public void setParent_contact(String parent_contact) {
        this.parent_contact = parent_contact;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "member_no=" + member_no +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", role_type='" + role_type + '\'' +
                ", birth_date=" + birth_date +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", enroll_date=" + enroll_date +
                ", school='" + school + '\'' +
                ", grade=" + grade +
                ", parent_contact='" + parent_contact + '\'' +
                '}';
    }
}
