package com.lastdance.project.planner.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FeedbackDTO {

    private int feedback_no;
    private int planner_no;
    private String feedback_txt;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date feedback_date;
    private int member_no;
    private String name;

    public FeedbackDTO() {
    }

    public FeedbackDTO(int feedback_no, int planner_no, String feedback_txt, Date feedback_date, int member_no, String name) {
        this.feedback_no = feedback_no;
        this.planner_no = planner_no;
        this.feedback_txt = feedback_txt;
        this.feedback_date = feedback_date;
        this.member_no = member_no;
        this.name = name;
    }

    public int getFeedback_no() {
        return feedback_no;
    }

    public void setFeedback_no(int feedback_no) {
        this.feedback_no = feedback_no;
    }

    public int getPlanner_no() {
        return planner_no;
    }

    public void setPlanner_no(int planner_no) {
        this.planner_no = planner_no;
    }

    public String getFeedback_txt() {
        return feedback_txt;
    }

    public void setFeedback_txt(String feedback_txt) {
        this.feedback_txt = feedback_txt;
    }

    public Date getFeedback_date() {
        return feedback_date;
    }

    public void setFeedback_date(Date feedback_date) {
        this.feedback_date = feedback_date;
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

    @Override
    public String toString() {
        return "FeedbackDTO{" +
                "feedback_no=" + feedback_no +
                ", planner_no=" + planner_no +
                ", feedback_txt='" + feedback_txt + '\'' +
                ", feedback_date=" + feedback_date +
                ", member_no=" + member_no +
                ", name='" + name + '\'' +
                '}';
    }
}
