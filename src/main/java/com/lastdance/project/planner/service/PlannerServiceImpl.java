package com.lastdance.project.planner.service;

import com.lastdance.project.planner.model.PlannerDAO;
import com.lastdance.project.planner.model.PlannerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String getNameByUserId(String id) {
        return plannerDAO.getNameByUserId(id);
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
}
