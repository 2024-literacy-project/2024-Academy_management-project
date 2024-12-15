package com.lastdance.project.notice.model.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class NoticeDTO {
   private int notice_no;
   private String notice_title;
   private String notice_txt;
   private LocalDate notice_date;
   private int member_no;

    public String getNotice_title() {
        return notice_title;
    }

    public void setNotice_title(String notice_title) {
        this.notice_title = notice_title;
    }

    public String getNotice_txt() {
        return notice_txt;
    }

    public void setNotice_txt(String notice_txt) {
        this.notice_txt = notice_txt;
    }

    public LocalDate getNotice_date() {
        return notice_date;
    }

    public void setNotice_date(LocalDate notice_date) {
        this.notice_date = notice_date;
    }

    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }

    public int getNotice_no() {
        return notice_no;
    }

    public void setNotice_no(int notice_no) {
        this.notice_no = notice_no;
    }


    public NoticeDTO(int notice_no, String notice_title, String notice_txt, LocalDate notice_date, int member_no) {
        this.notice_no = notice_no;
        this.notice_title = notice_title;
        this.notice_txt = notice_txt;
        this.notice_date = notice_date;
        this.member_no = member_no;
    }

    public NoticeDTO() {
    }

    @Override
    public String toString() {
        return "NoticeDTO{" +
                "notice_no=" + notice_no +
                ", notice_title='" + notice_title + '\'' +
                ", notice_txt='" + notice_txt + '\'' +
                ", notice_date=" + notice_date +
                ", member_no=" + member_no +
                '}';
    }
}
