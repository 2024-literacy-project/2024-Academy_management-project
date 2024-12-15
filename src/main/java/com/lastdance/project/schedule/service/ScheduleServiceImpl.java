package com.lastdance.project.schedule.service;

import com.lastdance.project.schedule.model.ScheduleDAO;
import com.lastdance.project.schedule.model.ScheduleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDAO scheduleDAO;

    @Override
    public List<ScheduleDTO> getStudentClass(String id) {
        return scheduleDAO.getStudentClass(id);
    }
}