package com.lastdance.project.class_support.model.dto;

import java.util.Date;

public class StudentAttendanceDTO {
    private int stu_attendance_no;
    private String stu_attendance_status;
    private Date stu_attendance_date;
    private int member_no;
    private String attendance_time;
    private String home_time;
    private int class_no; // 클래스 번호 추가

    public StudentAttendanceDTO() {
    }

    public StudentAttendanceDTO(int stu_attendance_no, String stu_attendance_status, Date stu_attendance_date, int member_no, String attendance_time, String home_time, int class_no) {
        this.stu_attendance_no = stu_attendance_no;
        this.stu_attendance_status = stu_attendance_status;
        this.stu_attendance_date = stu_attendance_date;
        this.member_no = member_no;
        this.attendance_time = attendance_time;
        this.home_time = home_time;
        this.class_no = class_no;
    }

    public int getStu_attendance_no() {
        return stu_attendance_no;
    }

    public void setStu_attendance_no(int stu_attendance_no) {
        this.stu_attendance_no = stu_attendance_no;
    }

    public String getStu_attendance_status() {
        return stu_attendance_status;
    }

    public void setStu_attendance_status(String stu_attendance_status) {
        this.stu_attendance_status = stu_attendance_status;
    }

    public Date getStu_attendance_date() {
        return stu_attendance_date;
    }

    public void setStu_attendance_date(Date stu_attendance_date) {
        this.stu_attendance_date = stu_attendance_date;
    }

    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }

    public String getAttendance_time() {
        return attendance_time;
    }

    public void setAttendance_time(String attendance_time) {
        this.attendance_time = attendance_time;
    }

    public String getHome_time() {
        return home_time;
    }

    public void setHome_time(String home_time) {
        this.home_time = home_time;
    }

    public int getClass_no() {
        return class_no;
    }

    public void setClass_no(int class_no) {
        this.class_no = class_no;
    }

    @Override
    public String toString() {
        return "StudentAttendanceDTO{" +
                "stu_attendance_no=" + stu_attendance_no +
                ", stu_attendance_status='" + stu_attendance_status + '\'' +
                ", stu_attendance_date=" + stu_attendance_date +
                ", member_no=" + member_no +
                ", attendance_time='" + attendance_time + '\'' +
                ", home_time='" + home_time + '\'' +
                ", class_no=" + class_no +
                '}';
    }
}
