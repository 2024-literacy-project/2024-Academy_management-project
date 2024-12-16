package com.lastdance.project.class_support.model.dto;

public class StudentClassDTO {
    private  int member_no;
    private int class_no;
    private String name;  // 학생 이름 추가

    public StudentClassDTO() {
    }

    public StudentClassDTO(int member_no, int class_no, String name) {
        this.member_no = member_no;
        this.class_no = class_no;
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }

    public int getClass_no() {
        return class_no;
    }

    public void setClass_no(int class_no) {
        this.class_no = class_no;
    }

    @Override
    public String toString() {
        return "StudentClassDTO{" +
                "member_no=" + member_no +
                ", class_no=" + class_no +
                ", name='" + name + '\'' +
                '}';
    }
}
