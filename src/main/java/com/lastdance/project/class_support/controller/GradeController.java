package com.lastdance.project.class_support.controller;

import com.lastdance.project.class_support.model.dto.*;
import com.lastdance.project.class_support.service.GradeService;
import com.lastdance.project.class_support.service.StudentAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/class_support")
public class GradeController {

    private final GradeService gradeService;
    private final StudentAttendanceService studentAttendanceService;

    @Autowired
    public GradeController(GradeService gradeService, StudentAttendanceService studentAttendanceService) {
        this.gradeService = gradeService;
        this.studentAttendanceService = studentAttendanceService;
    }

    // 성적 조회
    @GetMapping("/grades/search")
    @ResponseBody
    public Map<String, Object> getGradesByClassAndDate(
            @RequestParam("class_no") int classNo,
            @RequestParam("test_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate testDate,
            @RequestParam("test_no") int testNo
    ) {
        List<GradeDTO> gradeList = gradeService.getGradesByClassAndDate(classNo, testDate, testNo);


        Map<String, Object> response = new HashMap<>();
        response.put("grades", gradeList);
        response.put("total", gradeList.size());
        return response;
    }

    // 성적 등록
    @PostMapping("/register")
    @ResponseBody
    public String addGrade(@RequestBody GradeDTO gradeDTO) {
        gradeService.addGrade(gradeDTO);
        return "성적이 성공적으로 등록되었습니다.";
    }
    // 기존 시험에 점수 추가
    @PostMapping("/addScores")
    @ResponseBody
    public String addScores(@RequestBody List<ScoreDataDTO> scoreDataList) {
        gradeService.addScoresToExistingTest(scoreDataList);
        return "점수들이 성공적으로 등록/수정되었습니다.";
    }

    // 클래스별 시험 목록 조회
    @GetMapping("/testsByClass")
    @ResponseBody
    public List<TestDTO> getTestsByClass(@RequestParam("class_no") int classNo) {
        return gradeService.getTestsByClass(classNo);
    }
    @GetMapping("/studentsByTest")
    @ResponseBody
    public List<StudentDTO> getStudentsByTest(@RequestParam("test_no") int testNo) {
        return gradeService.getStudentsByTest(testNo);
    }

    // 시험별 학생 목록 조회
    @GetMapping("/studentsByClassAndTest")
    @ResponseBody
    public List<StudentDTO> getStudentsByClassAndTest(
            @RequestParam("class_no") int classNo,
            @RequestParam("test_no") int testNo
    ) {
        return gradeService.getStudentsByClassAndTest(classNo, testNo);
    }

    // 성적 수정
    @PutMapping("/update")
    @ResponseBody
    public String updateGrade(@RequestBody GradeDTO gradeDTO) {
        gradeService.updateGrade(gradeDTO);
        return "성적이 성공적으로 수정되었습니다.";
    }

    // 성적 삭제
    @DeleteMapping("/delete")
    @ResponseBody
    public String deleteGrade(@RequestParam("test_no") int testNo, @RequestParam("member_no") int memberNo) {
        gradeService.deleteGrade(testNo, memberNo);
        return "성적이 성공적으로 삭제되었습니다.";
    }

    // HTML 연결 - 성적 등록 페이지
    @GetMapping("/gradeRegistration")
    public String getGradeRegistrationPage(Model model) {
        // 클래스 목록 가져오기
        List<ClassDTO> classList = studentAttendanceService.getAllClassesForUI();
        // 시험 목록 가져오기
        List<TestDTO> testList = gradeService.getAllTests();
        // 모델에 추가
        model.addAttribute("classList", classList);
        model.addAttribute("testList", testList);
        return "class_support/gradeRegistration";
    }

    // 특정 클래스의 학생 목록 가져오기
    @GetMapping("/studentsByClass")
    @ResponseBody
    public List<StudentClassDTO> getStudentsByClass(@RequestParam("class_no") int classNo) {
        return studentAttendanceService.getStudentsByClass(classNo);
    }

    // HTML 연결 - 성적 조회 페이지
    @GetMapping("/gradeSearch")
    public String getGradeSearchPage(Model model) {
        // 클래스 목록 가져오기
        List<ClassDTO> classList = studentAttendanceService.getAllClassesForUI();
        // 시험 목록 가져오기
        List<TestDTO> testList = gradeService.getAllTests();
        // 모델에 추가
        model.addAttribute("classList", classList);
        model.addAttribute("testList", testList);
        return "class_support/gradeSearch";
    }

    // 추가: 모든 시험 정보를 제공하는 엔드포인트
    @GetMapping("/getAllTests")
    @ResponseBody
    public List<TestDTO> getAllTests() {
        return gradeService.getAllTests();
    }

    @GetMapping("/gradeUpdate")
    public String getGradeUpdatePage(Model model) {
        // 클래스 목록 가져오기
        List<ClassDTO> classList = studentAttendanceService.getAllClassesForUI();
        // 시험 목록 가져오기 (기존 시험 점수 추가를 위해 필요하다면)
        List<TestDTO> testList = gradeService.getAllTests();

        model.addAttribute("classList", classList);
        model.addAttribute("testList", testList);

        return "class_support/gradeUpdate";
    }

}
