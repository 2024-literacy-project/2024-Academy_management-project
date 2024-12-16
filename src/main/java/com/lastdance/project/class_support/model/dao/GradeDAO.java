package com.lastdance.project.class_support.model.dao;

import com.lastdance.project.class_support.model.dto.GradeDTO;
import com.lastdance.project.class_support.model.dto.ScoreDataDTO;
import com.lastdance.project.class_support.model.dto.StudentDTO;
import com.lastdance.project.class_support.model.dto.TestDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface GradeDAO {
    // 성적 등록
    int insertGrade(GradeDTO gradeDTO);

    // 성적 등록: Test 테이블에 시험 정보 삽입
    int insertTest(TestDTO testDTO);
    // 성적 조회 (클래스 기준)
    List<GradeDTO> getGradesByClassAndDate(@Param("class_no") int classNo, @Param("test_date") LocalDate testDate, @Param("test_no") int testNo);

    // 성적 조회
    List<TestDTO> getAllTests();
    // 클래스별 시험 목록 조회
    List<TestDTO> getTestsByClass(@Param("class_no") int classNo);

    // 시험별 학생 목록 조회
    List<StudentDTO> getStudentsByTest(@Param("test_no") int testNo);


    List<StudentDTO> getStudentsByClassAndTest(@Param("class_no") int classNo, @Param("test_no") int testNo);



    // 성적 삭제
    int deleteGrade(@Param("testNo") int testNo, @Param("memberNo") int memberNo);
    int updateGrade(GradeDTO gradeDTO);
    void updateTestResult(@Param("testNo") int testNo);

    int addClassTest(@Param("class_no") int classNo, @Param("test_no") int testNo, @Param("member_no") int memberNo);
    // 단일 학생 점수 추가/수정
    int addOrUpdateStudentTest(@Param("test_no") int testNo, @Param("member_no") int memberNo, @Param("score") int score);
    // 배치로 학생 점수 추가/수정

    int addOrUpdateStudentTests(@Param("list") List<ScoreDataDTO> scoreDataList);

}
