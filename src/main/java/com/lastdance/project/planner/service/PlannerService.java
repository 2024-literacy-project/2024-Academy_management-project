package com.lastdance.project.planner.service;

import com.lastdance.project.planner.model.FeedbackDTO;
import com.lastdance.project.planner.model.PlannerDTO;

import java.util.List;
import java.util.Optional;

public interface PlannerService {

    /* 플래너 목록 */
    List<PlannerDTO> getPlannerByUser(String id);

    /* 플래너 상세 페이지 */

    PlannerDTO getPlannerByNo(int planner_no);
    String getStudentNameByUserId(String id);

    int getMemberNoById(String id);

    /* 플래너 추가, 수정, 삭제 */

    void insertPlanner(PlannerDTO plannerDTO);
    void deletePlanner(int planner_no);

    void updatePlanner(PlannerDTO plannerDTO);

    Optional<PlannerDTO> findByNo(int planner_no);

    /* 플래너 피드백 */
    List<PlannerDTO> getPlannerByMemberNo(int member_no);

    List<FeedbackDTO> getFeedbackByPlannerNo(int planner_no);

    FeedbackDTO getFeedbackById(int feedback_no);

    String getTeacherNameByUserId(String id);

    /* 플래너 추가, 수정, 삭제 */
    void addFeedback(FeedbackDTO feedbackDTO);

    void updateFeedback(FeedbackDTO feedbackDTO);

    void deleteFeedback(int feedback_no);
}
