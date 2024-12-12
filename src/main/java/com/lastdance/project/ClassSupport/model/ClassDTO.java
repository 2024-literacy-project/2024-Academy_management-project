package com.lastdance.project.ClassSupport.model;

public class ClassDTO {

    private int class_no;
    private String class_name;
    private String name;
    private String class_schedule;
    private int member_no;
    private String id;

    public ClassDTO() {
    }

    public ClassDTO(int class_no, String class_name, String name, String class_schedule, int member_no, String id) {
        this.class_no = class_no;
        this.class_name = class_name;
        this.name = name;
        this.class_schedule = class_schedule;
        this.member_no = member_no;
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_schedule() {
        return class_schedule;
    }

    public void setClass_schedule(String class_schedule) {
        this.class_schedule = class_schedule;
    }

    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ClassDTO{" +
                "class_no=" + class_no +
                ", class_name='" + class_name + '\'' +
                ", name='" + name + '\'' +
                ", class_schedule='" + class_schedule + '\'' +
                ", member_no=" + member_no +
                ", id='" + id + '\'' +
                '}';
    }
}
