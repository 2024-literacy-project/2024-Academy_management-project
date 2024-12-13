package com.lastdance.project.subject.model.dto;

public class SubjectDTO {

    private int subject_no;                 //과목번호
    private String subject_name;            //과목명
    private String subject_start_date;      //과목시작일
    private String getSubject_finish_date;  //과목종료일
    private String class_time;              //수업시간
    private String class_day;               //수업요일

    //
    public SubjectDTO() {
    }

    public SubjectDTO(int subject_no, String subject_name, String subject_start_date, String getSubject_finish_date, String class_time, String class_day) {
        this.subject_no = subject_no;
        this.subject_name = subject_name;
        this.subject_start_date = subject_start_date;
        this.getSubject_finish_date = getSubject_finish_date;
        this.class_time = class_time;
        this.class_day = class_day;
    }

    //getter, setter
    public int getSubject_no() {
        return subject_no;
    }

    public void setSubject_no(int subject_no) {
        this.subject_no = subject_no;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_start_date() {
        return subject_start_date;
    }

    public void setSubject_start_date(String subject_start_date) {
        this.subject_start_date = subject_start_date;
    }

    public String getGetSubject_finish_date() {
        return getSubject_finish_date;
    }

    public void setGetSubject_finish_date(String getSubject_finish_date) {
        this.getSubject_finish_date = getSubject_finish_date;
    }

    public String getClass_time() {
        return class_time;
    }

    public void setClass_time(String class_time) {
        this.class_time = class_time;
    }

    public String getClass_day() {
        return class_day;
    }

    public void setClass_day(String class_day) {
        this.class_day = class_day;
    }

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "subject_no=" + subject_no +
                ", subject_name='" + subject_name + '\'' +
                ", subject_start_date='" + subject_start_date + '\'' +
                ", getSubject_finish_date='" + getSubject_finish_date + '\'' +
                ", class_time='" + class_time + '\'' +
                ", class_day='" + class_day + '\'' +
                '}';
    }

}
