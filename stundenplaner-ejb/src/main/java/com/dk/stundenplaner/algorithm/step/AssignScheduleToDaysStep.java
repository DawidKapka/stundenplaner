package com.dk.stundenplaner.algorithm.step;

import com.dk.stundenplaner.model.ScheduleEntry;
import com.dk.stundenplaner.model.SchoolClass;
import com.dk.stundenplaner.model.Teacher;
import com.dk.stundenplaner.model.Weekday;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class AssignScheduleToDaysStep {
    public Map<Teacher, List<ScheduleEntry>> assign(Map<Teacher, List<ScheduleEntry>> teachersWithModules, List<SchoolClass> classes) {
        classes.forEach(clazz -> {
            final List<ScheduleEntry> entriesForClass = accumulateEntriesForClass(teachersWithModules, clazz);
            final List<Weekday> availableDays = new ArrayList<>(Stream.of(Weekday.values())
                    .filter(day -> !clazz.getDaysUnavailable().contains(day))
                    .toList());
            final List<Weekday> daysToRemove = new ArrayList<>();
            entriesForClass.forEach(entry -> {
                availableDays.forEach(day -> {
                    if (!entry.getTeacher().getAvailableDays().contains(day)) {
                        daysToRemove.add(day);
                    }
                });
            });
            final List<Weekday> availableDaysForAll = availableDays.stream().filter(day -> !daysToRemove.contains(day)).toList();

            AtomicInteger lessonIndex = new AtomicInteger();
            AtomicInteger dayIndex = new AtomicInteger();
            entriesForClass.forEach(entry -> {
                if (lessonIndex.get() < 4) {
                    entry.setWeekday(availableDaysForAll.get(dayIndex.get()));
                    entry.setLesson(lessonIndex.get() + 1);
                    lessonIndex.getAndIncrement();
                } else {
                    lessonIndex.set(0);
                    dayIndex.getAndIncrement();
                }
            });
        });
        return teachersWithModules;
    }

    private List<ScheduleEntry> accumulateEntriesForClass(Map<Teacher, List<ScheduleEntry>> teachersWithModules, SchoolClass clazz) {
        final List<ScheduleEntry> entries = new ArrayList<>();
        teachersWithModules.forEach((key, value) -> {
            value.forEach(entry -> {
                if (entry.getAssignedSchoolClass() != null && entry.getModule() != null) {
                    if (entry.getAssignedSchoolClass().getName().equals(clazz.getName())) {
                        entries.add(entry);
                    }
                }
            });
        });
        return entries;
    }
}
