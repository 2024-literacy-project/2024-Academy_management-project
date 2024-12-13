package com.lastdance.project.class_support.model.dto;

import java.util.Date;

public class TestDTO {
    private int testNo;         // 시험 번호
    private String testName;    // 시험 이름
    private Date testDate;      // 시험 날짜
    private String testInfo;    // 시험 정보
    private Float testResult;   // 시험 평균 점수 (Nullable)

    // 기본 생성자
    public TestDTO() {}

    // 모든 필드 포함 생성자
    public TestDTO(int testNo, String testName, Date testDate, String testInfo, Float testResult) {
        this.testNo = testNo;
        this.testName = testName;
        this.testDate = testDate;
        this.testInfo = testInfo;
        this.testResult = testResult;
    }

    // Getters and Setters
    public int getTestNo() {
        return testNo;
    }

    public void setTestNo(int testNo) {
        this.testNo = testNo;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getTestInfo() {
        return testInfo;
    }

    public void setTestInfo(String testInfo) {
        this.testInfo = testInfo;
    }

    public Float getTestResult() {
        return testResult;
    }

    public void setTestResult(Float testResult) {
        this.testResult = testResult;
    }

    @Override
    public String toString() {
        return "TestDTO{" +
                "testNo=" + testNo +
                ", testName='" + testName + '\'' +
                ", testDate=" + testDate +
                ", testInfo='" + testInfo + '\'' +
                ", testResult=" + testResult +
                '}';
    }
}
