package com.lastdance.project.schedule.service;

import com.lastdance.project.schedule.model.ScheduleDAO;
import com.lastdance.project.schedule.model.ScheduleDTO;
import com.lastdance.project.schedule.model.TimeTableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    @Autowired
    private ScheduleDAO scheduleDAO;

    public List<TimeTableDTO> getTimeTable(String id) {
        List<ScheduleDTO> classList = scheduleDAO.getStudentClass(id);
        List<TimeTableDTO> timeTable = initializeTimeTable();

        for (ScheduleDTO schedule : classList) {
            if (schedule.getClass_day() == null || schedule.getClass_day().isEmpty()) {
                continue;
            }

            String[] timeRange = schedule.getClass_time().split("-"); // "14:00-16:00"
            String start = timeRange[0]; // "14:00"
            String end = timeRange[1];   // "16:00"

            // "14:00" -> "14", "16:00" -> "16"
            int startHour = Integer.parseInt(start.split(":")[0]);
            int endHour = Integer.parseInt(end.split(":")[0]);

            // "월수금" -> ['월', '수', '금']
            char[] days = schedule.getClass_day().toCharArray();

            for (char day : days) {
                for (int hour = startHour; hour < endHour; hour++) {
                    TimeTableDTO row = timeTable.get(hour - 9);
                    switch (day) {
                        case '월':
                            row.setMon(schedule.getClass_name());
                            break;
                        case '화':
                            row.setTue(schedule.getClass_name());
                            break;
                        case '수':
                            row.setWed(schedule.getClass_name());
                            break;
                        case '목':
                            row.setThu(schedule.getClass_name());
                            break;
                        case '금':
                            row.setFri(schedule.getClass_name());
                            break;
                        case '토':
                            row.setSat(schedule.getClass_name());
                            break;
                        case '일':
                            row.setSun(schedule.getClass_name());
                            break;
                    }
                }
            }
        }

        return timeTable;
    }

    private List<TimeTableDTO> initializeTimeTable() {
        List<TimeTableDTO> timeTable = new ArrayList<>();
        for (int hour = 9; hour <= 20; hour++) {
            String time = String.format("%02d:00 - %02d:00", hour, hour + 1);
            TimeTableDTO row = new TimeTableDTO();
            row.setTime(time);
            timeTable.add(row);
        }
        return timeTable;
    }
}
