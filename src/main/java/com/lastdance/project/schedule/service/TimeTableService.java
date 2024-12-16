package com.lastdance.project.schedule.service;

import com.lastdance.project.schedule.model.TimeTableDTO;

import java.util.List;

public interface TimeTableService {

    List<TimeTableDTO> getTimeTable(String id);
}
