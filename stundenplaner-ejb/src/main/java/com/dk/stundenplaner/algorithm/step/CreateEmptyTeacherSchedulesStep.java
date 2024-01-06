package com.dk.stundenplaner.algorithm.step;

import com.dk.stundenplaner.model.ScheduleEntry;
import com.dk.stundenplaner.model.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateEmptyTeacherSchedulesStep {

    public Map<Teacher, List<ScheduleEntry>> create(List<Teacher> teachers) {
        final Map<Teacher, List<ScheduleEntry>> schedules = new HashMap<>();
        teachers.forEach(teacher -> {
            final List<ScheduleEntry> entries = new ArrayList<>();
            int pensum = teacher.getPensum();
            while (pensum > 0) {
                entries.add(ScheduleEntry.builder().build());
                pensum--;
            }
            schedules.put(teacher, entries);
        });
        return schedules;
    }
}
