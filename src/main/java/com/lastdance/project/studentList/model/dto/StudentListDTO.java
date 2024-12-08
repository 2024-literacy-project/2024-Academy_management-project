package com.lastdance.project.studentList.model.dto;

import com.lastdance.project.member.enums.RoleType;

public class StudentListDTO {

    private int member_no;      //관련인번호
    private String school;      //소속학교
    private int grade;          //학년
    private String parent_contact;  //보호자연락처

    //member
    private String name;        //이름
    private String id;          //아이디
    private String password;    //비밀번호
    private RoleType role_type; //관련인종류
    private String birth_date;  //생년월일
    private String phone;       //전화번호
    private String address;     //주소
    private String enroll_date; //등록일

    //
    public StudentListDTO() {
    }

    public StudentListDTO(int member_no, String school, int grade, String parent_contact, String name, String id, String password, RoleType role_type, String birth_date, String phone, String address, String enroll_date) {
        this.member_no = member_no;
        this.school = school;
        this.grade = grade;
        this.parent_contact = parent_contact;
        this.name = name;
        this.id = id;
        this.password = password;
        this.role_type = role_type;
        this.birth_date = birth_date;
        this.phone = phone;
        this.address = address;
        this.enroll_date = enroll_date;
    }

    //getter, setter
    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
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

    public RoleType getRole_type() {
        return role_type;
    }

    public void setRole_type(RoleType role_type) {
        this.role_type = role_type;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
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

    public String getEnroll_date() {
        return enroll_date;
    }

    public void setEnroll_date(String enroll_date) {
        this.enroll_date = enroll_date;
    }

    @Override
    public String toString() {
        return "StudentListDTO{" +
                "member_no=" + member_no +
                ", school='" + school + '\'' +
                ", grade=" + grade +
                ", parent_contact='" + parent_contact + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", role_type=" + role_type +
                ", birth_date='" + birth_date + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", enroll_date='" + enroll_date + '\'' +
                '}';
    }


}
