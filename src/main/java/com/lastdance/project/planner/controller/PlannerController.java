package com.lastdance.project.planner.controller;

import com.lastdance.project.planner.model.FeedbackDTO;
import com.lastdance.project.planner.model.PlannerDTO;
import com.lastdance.project.planner.service.PlannerService;
import com.lastdance.project.planner.service.PlannerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student/planner")
public class PlannerController {

    @Autowired
    private PlannerService plannerService;
    @Autowired
    private PlannerServiceImpl plannerServiceImpl;

    // 학생 아이디 고정
    private final String fixedId = "junho";

    // 플래너 목록
    @GetMapping("/list")
    public String getPlannerByUser(Model model, Principal principal) {

        String studentId = principal.getName(); // 로그인한 사용자 ID 가져오기

        System.out.println("studentId: " + studentId);

        List<PlannerDTO> plannerDTO = plannerServiceImpl.getPlannerByUser(studentId);
        model.addAttribute("plannerList", plannerDTO);

        return "student/planner/list";
    }

    // 플래너 상세 페이지
    @GetMapping("/details/{planner_no}")
    public String getPlannerDetails(@PathVariable int planner_no, Model model) {

        PlannerDTO plannerDTO = plannerServiceImpl.getPlannerByNo(planner_no);
        List<FeedbackDTO> feedbackList = plannerServiceImpl.getFeedbackByPlannerNo(planner_no);

        feedbackList.removeIf(feedback -> feedback == null);

        if (feedbackList.isEmpty()) {
            System.out.println("피드백이 없습니다.");
        } else {
            for (FeedbackDTO feedback : feedbackList) {
                System.out.println("피드백 번호: " + feedback.getFeedback_no());
            }
        }
        model.addAttribute("plannerDTO",plannerDTO);
        model.addAttribute("feedbackList", feedbackList);

        return "student/planner/details";
    }

    // 플래너 추가
    @GetMapping("/add")
    public String getAddPlannerForm(Model model, Principal principal) {

        String studentId = principal.getName(); // 로그인한 사용자 ID 가져오기

//        String userName = plannerServiceImpl.getStudentNameByUserId(fixedId);

        PlannerDTO plannerDTO = new PlannerDTO();
        plannerDTO.setName(studentId);

        model.addAttribute("plannerDTO", plannerDTO);

        return "student/planner/add";
    }

    @PostMapping("/add")
    public String addPlanner(@ModelAttribute PlannerDTO plannerDTO, Principal principal) {

        String studentId = principal.getName(); // 로그인한 사용자 ID 가져오기

        int memberNo = plannerServiceImpl.getMemberNoById(studentId);
        plannerDTO.setMember_no(memberNo);
        plannerServiceImpl.insertPlanner(plannerDTO);

        return "redirect:/student/planner/list";
    }

    // 플래너 수정
    @GetMapping("/update/{planner_no}")
    public String getUpdatePlannerForm(@PathVariable int planner_no, Model model) {

        Optional<PlannerDTO> plannerDTO = plannerServiceImpl.findByNo(planner_no);
        model.addAttribute("plannerDTO", plannerDTO.get());

        return "student/planner/update";
    }

    @PostMapping("/update")
    public String updatePlanner(@ModelAttribute PlannerDTO plannerDTO, Principal principal) {

        String studentId = principal.getName(); // 로그인한 사용자 ID 가져오기

        int memberNo = plannerServiceImpl.getMemberNoById(studentId);
        plannerDTO.setMember_no(memberNo);
        plannerDTO.setId(studentId);

        plannerServiceImpl.updatePlanner(plannerDTO);

        return "redirect:/student/planner/list";
    }

    // 플래너 삭제
    @GetMapping("/delete/{planner_no}")
    public String deletePlanner(@PathVariable int planner_no) {

        plannerServiceImpl.deletePlanner(planner_no);

        return "redirect:/student/planner/list";
    }
}

