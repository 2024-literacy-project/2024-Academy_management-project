package com.lastdance.project.planner.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlannerDAO {

    /* 플래너 목록 */
    List<PlannerDTO> getPlannerByUserId(String id);

    List<PlannerDTO> getPlannerByMemberNo(int member_no);

    /* 플래너 상세 페이지 */
    PlannerDTO getPlannerByNo(int planner_no);

    String getStudentNameByUserId(String id);
    int getMemberNoById(String id);

    /* 플래너 추가,수정,삭제 */

    void insertPlanner(PlannerDTO plannerDTO);
    void deletePlanner(int planner_no);

    void updatePlanner(PlannerDTO plannerDTO);

    PlannerDTO findByNo(int planner_no);


    /* 플래너 피드백 */
    List<FeedbackDTO> getFeedbackByPlannerNo(int planner_no);
    FeedbackDTO getFeedbackById(int feedback_no);
    String getTeacherNameByUserId(String id);

    /* 피드백 추가, 수정, 삭제 */
    void addFeedback(FeedbackDTO feedbackDTO);

    void updateFeedback(FeedbackDTO feedbackDTO);

    void deleteFeedback(int feedback_no);
}
