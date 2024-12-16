package com.lastdance.project.classList.controller;

import com.lastdance.project.classList.model.dto.ClassListDTO;
import com.lastdance.project.classList.service.ClassListServiceImpl;
import com.lastdance.project.member.model.dto.MemberDTO;
import com.lastdance.project.member.service.MemberServiceImpl;
import com.lastdance.project.studentList.model.dto.StudentListDTO;
import com.lastdance.project.subject.model.dto.SubjectDTO;
import com.lastdance.project.subject.service.SubjectServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/classList")
public class ClassListController {

    private final ClassListServiceImpl classListServiceImpl;
    private final SubjectServiceImpl subjectServiceImpl;
    private final MemberServiceImpl memberServiceImpl;

//    @Autowired
//    public ClassListController(ClassListServiceImpl classListServiceImpl) {
//        this.classListServiceImpl = classListServiceImpl;
//    }

    public ClassListController(ClassListServiceImpl classListServiceImpl, SubjectServiceImpl subjectServiceImpl, MemberServiceImpl memberServiceImpl) {
        this.classListServiceImpl = classListServiceImpl;
        this.subjectServiceImpl = subjectServiceImpl;
        this.memberServiceImpl = memberServiceImpl;
    }

    /* 클래스리스트 확인 */
//    @GetMapping("/classList")
    @GetMapping
    public String getAllClassList(Model model) {
        List<ClassListDTO> classList = classListServiceImpl.getAllClassList();
        model.addAttribute("classList", classList);
        return "classList/classList";
    }

    /* 클래스리스트 추가 */
    @PostMapping("/addClass")
    public String addClass(ClassListDTO classListDTO) {
        classListServiceImpl.addClass(classListDTO);
        return "redirect:/classList"; // 추가 후 목록 페이지로 리다이렉트
    }

    /*@GetMapping("/addClass")
    public String showAddClassPage() {  //클래스 추가 페이지 띄우기
        return "classList/addClass";
    }*/
    @GetMapping("/addClass")
    public String showAddClassPage(Model model) {
        // 과목 리스트와 관련인 리스트를 조회
        List<SubjectDTO> subjects = subjectServiceImpl.getAllSubjects();
        List<MemberDTO> members = memberServiceImpl.getAllMembers();
        // 모델에 추가
        model.addAttribute("subjects", subjects);
        model.addAttribute("members", members);

        return "classList/addClass";  // 클래스 추가 페이지 렌더링
    }


    /* 클래스리스트 상세보기 */
    @GetMapping("/detail/{class_no}")
    public String getClassDetail(@PathVariable("class_no") int classNo, Model model) {
        ClassListDTO classDetail = classListServiceImpl.getClassByNo(classNo);
        model.addAttribute("classDetail", classDetail); // 상세정보를 모델에 추가
        return "classList/classDetail"; // 상세보기 페이지 렌더링
    }

    /* 클래스리스트 수정 */
    /*@GetMapping("/edit/{class_no}")
    public String showEditClass(@PathVariable("class_no") int classNo, Model model){
        ClassListDTO classDetail = classListServiceImpl.getClassByNo(classNo);
        model.addAttribute("classDetail", classDetail);
        return "classList/editClass";
    }*/
    @GetMapping("/edit/{class_no}")
    public String showEditClass(@PathVariable("class_no") int classNo, Model model) {
        // 기존 클래스 상세 정보 가져오기
        ClassListDTO classDetail = classListServiceImpl.getClassByNo(classNo);
        model.addAttribute("classDetail", classDetail);

        // 과목 리스트 추가
        List<SubjectDTO> subjectList = subjectServiceImpl.getAllSubjects(); // SubjectService를 호출
        model.addAttribute("subjectList", subjectList);

        // 관련인 리스트 추가
        List<MemberDTO> memberList = memberServiceImpl.getAllMembers(); // MemberService를 호출
        model.addAttribute("memberList", memberList);

        return "classList/editClass"; // 수정 페이지로 이동
    }


    @PostMapping("/edit/{class_no}")
    public String updateClass(@PathVariable("class_no") int classNo, ClassListDTO classListDTO){
        classListDTO.setClass_no(classNo);  //
        classListServiceImpl.updateClass(classListDTO);
        return "redirect:/classList";       //수정 후 -> 목록 페이지로
    }

    /* 클래스리스트 삭제 */
    @GetMapping("/delete/{class_no}")
    public String deleteClass(@PathVariable("class_no") int classNo) {
        classListServiceImpl.deleteClass(classNo); // 삭제 처리
        return "redirect:/classList"; // 삭제 후 목록 페이지로 리다이렉트
    }


    /* 클래스-학생 조회 */
    @GetMapping("/{class_no}/classStudents")
    public String getStudentsByClassNo(@PathVariable("class_no") int classNo, Model model){
        List<StudentListDTO> studentList = classListServiceImpl.getStudentsByClassNo(classNo);
        ClassListDTO classDetail = classListServiceImpl.getClassByNo(classNo);

        model.addAttribute("studentList", studentList);
        model.addAttribute("classDetail", classDetail);
        return "classList/classStudents";
    }

}
