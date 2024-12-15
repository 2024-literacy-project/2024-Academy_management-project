package com.lastdance.project.sessionsecurity.user.model.dto;

public class StudentDTO {

    private int memberNo; // FK로 참조
    private String school;
    private int grade;
    private String parentContact;

    public StudentDTO() {
    }

    public StudentDTO(int memberNo, String school, int grade, String parentContact) {
        this.memberNo = memberNo;
        this.school = school;
        this.grade = grade;
        this.parentContact = parentContact;
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

    public String getParentContact() {
        return parentContact;
    }

    public void setParentContact(String parentContact) {
        this.parentContact = parentContact;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "memberNo=" + memberNo +
                ", school='" + school + '\'' +
                ", grade=" + grade +
                ", parentContact='" + parentContact + '\'' +
                '}';
    }
}
