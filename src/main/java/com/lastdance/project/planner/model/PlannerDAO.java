package com.lastdance.project.planner.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlannerDAO {

    /* 플래너 목록 */
    List<PlannerDTO> getPlannerByUserId(String id);

    /* 플래너 상세 페이지 */
    PlannerDTO getPlannerByNo(int planner_no);

    String getNameByUserId(String id);

    int getMemberNoById(String id);

    /* 플래너 추가,수정,삭제 */
    void insertPlanner(PlannerDTO plannerDTO);

    void deletePlanner(int planner_no);

    void updatePlanner(PlannerDTO plannerDTO);

    PlannerDTO findByNo(int planner_no);
}
