package com.lastdance.project.schedule.service;

import com.lastdance.project.schedule.model.ScheduleDTO;
import java.util.List;

public interface ScheduleService {

    List<ScheduleDTO> getStudentClass(String id);
}
