package com.lastdance.project.class_support.model.dto;

import java.util.Date;

public class GradeDTO {
    private int testNo; // 성적 ID (Primary Key)
    private int classNo; // 클래스 번호
    private int memberNo; // 학생 번호
    private String studentName; // 학생 이름
    private String testInfo; // 시험 정보
    private double score; // 성적
    private Date testDate; // 시험 날짜 (YYYY-MM-DD)
    private String testName;

    // 기본 생성자
    public GradeDTO() {}

    // 모든 필드 포함 생성자
    public GradeDTO(int testNo, int classNo, int memberNo, String studentName, String testInfo, double score, Date testDate, String testName) {
        this.testNo = testNo;
        this.classNo = classNo;
        this.memberNo = memberNo;
        this.studentName = studentName;
        this.testInfo = testInfo;
        this.score = score;
        this.testDate = testDate;
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    // Getter와 Setter


    public int getTestNo() {
        return testNo;
    }

    public void setTestNo(int testNo) {
        this.testNo = testNo;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTestInfo() {
        return testInfo;
    }

    public void setTestInfo(String testInfo) {
        this.testInfo = testInfo;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    @Override
    public String toString() {
        return "GradeDTO{" +
                "testNo=" + testNo +
                ", classNo=" + classNo +
                ", memberNo=" + memberNo +
                ", studentName='" + studentName + '\'' +
                ", testInfo='" + testInfo + '\'' +
                ", score=" + score +
                ", testDate=" + testDate +
                ", testName='" + testName + '\'' +
                '}';
    }
}
