package com.lastdance.project.class_support.model.dto;

public class ClassDTO {
    private int class_no; // 클래스 번호
    private String class_name; // 클래스명
    private String class_schedule; // 수업 일정
    private int subject_no; // 과목 번호
    private int member_no; // 관련인 번호 (직원)

    public ClassDTO() {
    }

    public ClassDTO(int class_no, String class_name, String class_schedule, int subject_no, int member_no) {
        this.class_no = class_no;
        this.class_name = class_name;
        this.class_schedule = class_schedule;
        this.subject_no = subject_no;
        this.member_no = member_no;
    }

    public int getClass_no() {
        return class_no;
    }

    public void setClass_no(int class_no) {
        this.class_no = class_no;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_schedule() {
        return class_schedule;
    }

    public void setClass_schedule(String class_schedule) {
        this.class_schedule = class_schedule;
    }

    public int getSubject_no() {
        return subject_no;
    }

    public void setSubject_no(int subject_no) {
        this.subject_no = subject_no;
    }

    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }

    @Override
    public String toString() {
        return "ClassDTO{" +
                "class_no=" + class_no +
                ", class_name='" + class_name + '\'' +
                ", class_schedule='" + class_schedule + '\'' +
                ", subject_no=" + subject_no +
                ", member_no=" + member_no +
                '}';
    }
}
