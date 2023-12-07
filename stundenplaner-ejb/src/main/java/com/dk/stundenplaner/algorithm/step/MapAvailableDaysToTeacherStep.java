package com.dk.stundenplaner.algorithm.step;

import com.dk.stundenplaner.model.Teacher;
import com.dk.stundenplaner.model.Weekday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapAvailableDaysToTeacherStep {

    public static Map<Teacher, List<Weekday>> map(List<Teacher> teachers) {
        final Map<Teacher, List<Weekday>> availableDaysForTeacher = new HashMap<>();
        teachers.forEach(teacher -> {
            final List<Weekday> availableDays = Arrays.stream(Weekday.values())
                    .filter(day -> teacher.getAvailableDays().contains(day))
                    .toList();
            availableDaysForTeacher.put(teacher, availableDays);
        });
        return availableDaysForTeacher;
    }
}
