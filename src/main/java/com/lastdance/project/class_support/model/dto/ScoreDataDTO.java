package com.lastdance.project.class_support.model.dto;
//여러 학생의 점수를 한 번에 처리하기 위해 새로운 DTO를 생성
public class ScoreDataDTO {
    private int testNo;
    private int memberNo;
    private Integer score;

    public ScoreDataDTO() {
    }

    public ScoreDataDTO(int testNo, int memberNo, Integer score) {
        this.testNo = testNo;
        this.memberNo = memberNo;
        this.score = score;
    }

    public int getTestNo() {
        return testNo;
    }

    public void setTestNo(int testNo) {
        this.testNo = testNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ScoreDateDTO{" +
                "testNo=" + testNo +
                ", memberNo=" + memberNo +
                ", score=" + score +
                '}';
    }
}
