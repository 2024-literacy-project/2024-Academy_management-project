package com.lastdance.project.class_support.model.dto;

public class StudentDTO {
    private String name;
    private String school; // 소속 학교
    private int grade; // 학년
    private String parent_contact; // 보호자 연락처
    private int member_no; // 관련인 번호

    public StudentDTO() {
    }

    public StudentDTO(String name, String school, int grade, String parent_contact, int member_no) {
        this.name = name;
        this.school = school;
        this.grade = grade;
        this.parent_contact = parent_contact;
        this.member_no = member_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", grade=" + grade +
                ", parent_contact='" + parent_contact + '\'' +
                ", member_no=" + member_no +
                '}';
    }
}
