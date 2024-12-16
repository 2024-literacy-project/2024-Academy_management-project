package com.lastdance.project.schedule.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleDAO {

    List<ScheduleDTO> getStudentClass(String id);

    List<TimeTableDTO> getTimeTable(String id);
}
