package com.lastdance.project.planner.controller;

import com.lastdance.project.planner.model.FeedbackDTO;
import com.lastdance.project.planner.model.PlannerDTO;
import com.lastdance.project.planner.service.PlannerService;
import com.lastdance.project.planner.service.PlannerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/class-support/class-list")
public class FeedbackController {

    @Autowired
    private PlannerService plannerService;
    @Autowired
    private PlannerServiceImpl plannerServiceImpl;

    // 강사 아이디 고정
    private final String fixedId = "minsoo";

    // 플래너 목록
    @GetMapping("/{member_no}")
    public String getPlannerListByMemberNo(@PathVariable int member_no, Model model) {
        List<PlannerDTO> plannerList = plannerServiceImpl.getPlannerByMemberNo(member_no);

        System.out.println(plannerList);

        model.addAttribute("plannerList", plannerList);
        return "class-support/feedback/planner-list";
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

        return "class-support/feedback/planner-details";
    }

    // 피드백 작성
    @GetMapping("/feedback/add/{planner_no}")
    public String showAddFeedbackPage(@PathVariable int planner_no,Model model) {

        String userName = plannerServiceImpl.getTeacherNameByUserId(fixedId);
        PlannerDTO plannerDTO = plannerServiceImpl.getPlannerByNo(planner_no);

        FeedbackDTO feedbackList = new FeedbackDTO();
        feedbackList.setName(userName);
        System.out.println("강사 이름: " + userName);

        model.addAttribute("plannerDTO",plannerDTO);
        model.addAttribute("feedbackList", feedbackList);

        return "class-support/feedback/add";
    }

    @PostMapping("/feedback/add")
    public String addFeedback(@ModelAttribute FeedbackDTO feedbackDTO) {

        int memberNo = plannerServiceImpl.getMemberNoById(fixedId);
        feedbackDTO.setMember_no(memberNo);

        plannerServiceImpl.addFeedback(feedbackDTO);

        return "redirect:/class-support/class-list/details/" + feedbackDTO.getPlanner_no();
    }

    // 피드백 수정
    @GetMapping("/feedback/update/{feedback_no}")
    public String showUpdateFeedbackPage(@PathVariable int feedback_no, Model model) {

        String userName = plannerServiceImpl.getTeacherNameByUserId(fixedId);
        FeedbackDTO feedback = plannerServiceImpl.getFeedbackById(feedback_no);
        feedback.setName(userName);

        if (feedback == null) {
            throw new IllegalArgumentException("Invalid feedback_no: " + feedback_no);
        }
        PlannerDTO plannerDTO = plannerServiceImpl.getPlannerByNo(feedback.getPlanner_no());

        model.addAttribute("plannerDTO", plannerDTO);
        model.addAttribute("feedback", feedback);
        return "class-support/feedback/update";
    }

    @PostMapping("/feedback/update")
    public String updateFeedback(@ModelAttribute FeedbackDTO feedbackDTO) {
        plannerServiceImpl.updateFeedback(feedbackDTO);
        return "redirect:/class-support/class-list/details/" + feedbackDTO.getPlanner_no();
    }

    // 피드백 삭제
    @PostMapping("/feedback/delete/{feedback_no}")
    public String deleteFeedback(@PathVariable int feedback_no, @RequestParam int planner_no) {
        plannerServiceImpl.deleteFeedback(feedback_no);
        return "redirect:/class-support/class-list/details/" + planner_no;
    }

}
