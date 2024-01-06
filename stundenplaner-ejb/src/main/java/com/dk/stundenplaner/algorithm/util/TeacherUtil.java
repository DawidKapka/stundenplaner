package com.dk.stundenplaner.algorithm.util;

import com.dk.stundenplaner.model.ScheduleEntry;
import com.dk.stundenplaner.model.Teacher;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TeacherUtil {

    public static int calculateTotalCapacity(Map<Teacher, List<ScheduleEntry>> schedules) {
        AtomicInteger capacity = new AtomicInteger();
        schedules.forEach((key, value) -> {
            capacity.addAndGet(value.size());
        });
        return capacity.get();
    }
}
