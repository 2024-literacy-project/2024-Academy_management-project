package com.lastdance.project.class_support.controller;

import com.lastdance.project.class_support.model.dto.ClassDTO;
import com.lastdance.project.class_support.model.dto.GradeDTO;
import com.lastdance.project.class_support.model.dto.StudentClassDTO;
import com.lastdance.project.class_support.service.GradeService;
import com.lastdance.project.class_support.service.StudentAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/search")
    @ResponseBody
    public Map<String, Object> getGradesByClassAndDate(
            @RequestParam("class_no") int classNo,
            @RequestParam("test_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date testDate) {

        List<GradeDTO> gradeList = gradeService.getGradesByClassAndDate(classNo, testDate);

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

    // 성적 수정
    @PutMapping("/update")
    public String updateGrade(@RequestBody GradeDTO gradeDTO) {
        gradeService.updateGrade(gradeDTO);
        return "성적이 성공적으로 수정되었습니다.";
    }

    // 성적 삭제
    @DeleteMapping("/delete")
    public String deleteGrade(@RequestParam("test_no") int testNo, @RequestParam("member_no") int memberNo) {
        gradeService.deleteGrade(testNo, memberNo);
        return "성적이 성공적으로 삭제되었습니다.";
    }

    // HTML 연결 - 성적 등록 페이지
    @GetMapping("/gradeRegistration")
    public String getGradeRegistrationPage(Model model) {
        // 필요한 데이터 추가 (예: 클래스 목록, 시험 정보 등)
        List<ClassDTO> classList = studentAttendanceService.getAllClassesForUI();
        model.addAttribute("classList", classList);
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
        // 필요한 데이터 추가 (예: 클래스 목록 등)
        return "class_support/gradeSearch";
    }
}
