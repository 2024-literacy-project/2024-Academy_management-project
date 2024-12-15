package com.lastdance.project.planner.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PlannerDTO {

    private int planner_no;
    private String planner_title;
    private String planner_txt;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date planner_date;
    private int member_no;
    private String name;
    private String id;



    public PlannerDTO() {
    }

    public PlannerDTO(int planner_no, String planner_title, String planner_txt, Date planner_date, int member_no, String name, String id) {
        this.planner_no = planner_no;
        this.planner_title = planner_title;
        this.planner_txt = planner_txt;
        this.planner_date = planner_date;
        this.member_no = member_no;
        this.name = name;
        this.id = id;
    }

    public int getPlanner_no() {
        return planner_no;
    }

    public void setPlanner_no(int planner_no) {
        this.planner_no = planner_no;
    }

    public String getPlanner_title() {
        return planner_title;
    }

    public void setPlanner_title(String planner_title) {
        this.planner_title = planner_title;
    }

    public String getPlanner_txt() {
        return planner_txt;
    }

    public void setPlanner_txt(String planner_txt) {
        this.planner_txt = planner_txt;
    }

    public Date getPlanner_date() {
        return planner_date;
    }

    public void setPlanner_date(Date planner_date) {
        this.planner_date = planner_date;
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

    @Override
    public String toString() {
        return "PlannerDTO{" +
                "planner_no=" + planner_no +
                ", planner_title='" + planner_title + '\'' +
                ", planner_txt='" + planner_txt + '\'' +
                ", planner_date=" + planner_date +
                ", member_no=" + member_no +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
