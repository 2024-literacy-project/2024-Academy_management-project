package com.lastdance.project.schedule.model;

public class ScheduleDTO {

    private int class_no;
    private String class_name;
    private String class_schedule;
    private String subject_name;
    private String name;
    private String class_day;
    private String class_time;

    public ScheduleDTO() {
    }

    public ScheduleDTO(int class_no, String class_name, String class_schedule, String subject_name, String name, String class_day, String class_time) {
        this.class_no = class_no;
        this.class_name = class_name;
        this.class_schedule = class_schedule;
        this.subject_name = subject_name;
        this.name = name;
        this.class_day = class_day;
        this.class_time = class_time;
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

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_day() {
        return class_day;
    }

    public void setClass_day(String class_day) {
        this.class_day = class_day;
    }

    public String getClass_time() {
        return class_time;
    }

    public void setClass_time(String class_time) {
        this.class_time = class_time;
    }

    @Override
    public String toString() {
        return "ScheduleDTO{" +
                "class_no=" + class_no +
                ", class_name='" + class_name + '\'' +
                ", class_schedule='" + class_schedule + '\'' +
                ", subject_name='" + subject_name + '\'' +
                ", name='" + name + '\'' +
                ", class_day='" + class_day + '\'' +
                ", class_time='" + class_time + '\'' +
                '}';
    }
}
