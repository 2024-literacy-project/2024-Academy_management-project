package com.lastdance.project.planner.service;

import com.lastdance.project.planner.model.FeedbackDTO;
import com.lastdance.project.planner.model.PlannerDAO;
import com.lastdance.project.planner.model.PlannerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlannerServiceImpl implements PlannerService {

    @Autowired
    private PlannerDAO plannerDAO;

    /* 플래너 목록 */
    @Override
    public List<PlannerDTO> getPlannerByUser(String id) {
        return plannerDAO.getPlannerByUserId(id);
    }

    /* 플래너 상세 페이지 */
    @Override
    public PlannerDTO getPlannerByNo(int planner_no) {
        return plannerDAO.getPlannerByNo(planner_no);
    }

    @Override
    public String getStudentNameByUserId(String id) {
        return plannerDAO.getStudentNameByUserId(id);
    }

    @Override
    public int getMemberNoById(String id) {
        return plannerDAO.getMemberNoById(id);
    }

    /* 플래너 추가, 수정, 삭제 */
    @Override
    public void insertPlanner(PlannerDTO plannerDTO) {
        plannerDAO.insertPlanner(plannerDTO);
    }

    @Override
    public void deletePlanner(int planner_no) {
        plannerDAO.deletePlanner(planner_no);
    }

    @Override
    public void updatePlanner(PlannerDTO plannerDTO) {
        plannerDAO.updatePlanner(plannerDTO);
    }

    /* 특정 ID로 조회 */
    @Override
    public Optional<PlannerDTO> findByNo(int planner_no) {        //수정에 사용
        PlannerDTO plannerDTO = plannerDAO.findByNo(planner_no);
        return Optional.ofNullable(plannerDTO);
    }

    /* 플래너 피드백 */

    @Override
    public List<PlannerDTO> getPlannerByMemberNo(int member_no) {
        return plannerDAO.getPlannerByMemberNo(member_no);
    }
    @Override
    public List<FeedbackDTO> getFeedbackByPlannerNo(int planner_no) {

        List<FeedbackDTO> feedbackList = plannerDAO.getFeedbackByPlannerNo(planner_no);
        if (feedbackList == null || feedbackList.isEmpty()) {
            return new ArrayList<>(); // 빈 리스트 반환
        }
        return feedbackList;
    }

    @Override
    public FeedbackDTO getFeedbackById(int feedback_no) {
        return plannerDAO.getFeedbackById(feedback_no);
    }

    @Override
    public String getTeacherNameByUserId(String id) {
        return plannerDAO.getTeacherNameByUserId(id);
    }

    /* 피드백 추가, 수정, 삭제*/
    @Override
    public void addFeedback(FeedbackDTO feedbackDTO) {
        plannerDAO.addFeedback(feedbackDTO);
    }

    @Override
    public void updateFeedback(FeedbackDTO feedbackDTO) {
        plannerDAO.updateFeedback(feedbackDTO);
    }

    @Override
    public void deleteFeedback(int feedback_no) {
        plannerDAO.deleteFeedback(feedback_no);
    }

}
