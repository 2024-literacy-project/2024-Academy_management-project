package com.lastdance.project.sessionsecurity.user.model.dto;

import java.time.LocalDate;

public class ExamResultDTO {

    private int examNo; // 시험 번호
    private String examName; // 시험 이름
    private LocalDate examDate; // 시험 날짜
    private double score; // 성적
    private double avg;

    public ExamResultDTO() {
    }

    public ExamResultDTO(int examNo, String examName, LocalDate examDate, double score, double avg) {
        this.examNo = examNo;
        this.examName = examName;
        this.examDate = examDate;
        this.score = score;
        this.avg = avg;
    }

    public int getExamNo() {
        return examNo;
    }

    public void setExamNo(int examNo) {
        this.examNo = examNo;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "ExamResultDTO{" +
                "examNo=" + examNo +
                ", examName='" + examName + '\'' +
                ", examDate=" + examDate +
                ", score=" + score +
                ", avg=" + avg +
                '}';
    }
}
