package com.dk.stundenplaner.algorithm.step;

import com.dk.stundenplaner.model.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AssignModulesToTeachersStep {
    public Map<Teacher, List<ScheduleEntry>> assign(Map<Teacher, List<ScheduleEntry>> teacherSchedules, List<SchoolClass> classes, List<SchoolModule> modules) {
        classes.forEach(clazz -> {
            final List<SchoolModule> classModules = clazz.getModules().stream()
                    .map(moduleName -> modules.stream()
                            .filter(m -> m.getShortcut().equals(moduleName))
                            .toList()
                            .get(0))
                    .toList();
            classModules.forEach(module -> {
                teacherSchedules.forEach((teacher, schedule) -> {
                    if (teacher.getModules().contains(module.getShortcut()) && teacherHasCapacity(schedule, module.getDuration())) {
                        schedule = addModuleToSchedule(schedule, module, clazz, teacher);
                    }
                });
            });
        });
        return teacherSchedules;
    }

    private List<ScheduleEntry> addModuleToSchedule(List<ScheduleEntry> schedule, SchoolModule module, SchoolClass clazz, Teacher teacher) {
        AtomicInteger index = new AtomicInteger(0);
        AtomicInteger moduleLength = new AtomicInteger();
        if (module.getDuration() == LessonDuration.SINGLE) {
            moduleLength.set(1);
        } else if (module.getDuration() == LessonDuration.DOUBLE) {
            moduleLength.set(2);
        } else {
            moduleLength.set(3);
        }

        schedule.forEach(entry -> {
            if (index.get() < moduleLength.get()) {
                if (entry.getModule() == null && entry.getAssignedSchoolClass() == null) {
                    entry.setModule(module);
                    entry.setAssignedSchoolClass(clazz);
                    entry.setTeacher(teacher);
                    index.getAndIncrement();
                }
            }
        });
        return schedule;
    }

    private boolean teacherHasCapacity(List<ScheduleEntry> entries, LessonDuration duration) {
        final int emptyEntries = entries.stream().filter(entry -> entry.getAssignedSchoolClass() == null && entry.getModule() == null).toList().size();
        if (duration == LessonDuration.SINGLE) {
            return emptyEntries >= 1;
        } else if (duration == LessonDuration.DOUBLE) {
            return emptyEntries >= 2;
        } else {
            return emptyEntries >= 3;
        }
    }
}
