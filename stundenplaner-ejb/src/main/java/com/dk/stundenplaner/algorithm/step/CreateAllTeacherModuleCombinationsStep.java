package com.dk.stundenplaner.algorithm.step;

import com.dk.stundenplaner.algorithm.util.TeacherUtil;
import com.dk.stundenplaner.model.LessonDuration;
import com.dk.stundenplaner.model.ScheduleEntry;
import com.dk.stundenplaner.model.SchoolModule;
import com.dk.stundenplaner.model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CreateAllTeacherModuleCombinationsStep {

    public List<Map<Teacher, List<ScheduleEntry>>> create(List<SchoolModule> modules, Map<Teacher, List<ScheduleEntry>> teacherSchedules) {
        final int totalTeacherCapacity = TeacherUtil.calculateTotalCapacity(teacherSchedules);
        final List<List<SchoolModule>> allModuleCombinations = createAllModuleCombinations(modules, totalTeacherCapacity);
        return assignModuleListToTeachers(teacherSchedules, allModuleCombinations);
    }

    private List<Map<Teacher, List<ScheduleEntry>>> assignModuleListToTeachers(Map<Teacher, List<ScheduleEntry>> teacherSchedules, List<List<SchoolModule>> allModuleCombinations) {
        final List<Map<Teacher, List<ScheduleEntry>>> possibleSchedules = new ArrayList<>();
        allModuleCombinations.forEach(combination -> {
            final Map<Teacher, List<ScheduleEntry>> schedules =teacherSchedules;
            schedules.forEach((key, value) -> {
                AtomicInteger currentScheduleIndex = new AtomicInteger();
                combination.forEach(module -> {
                    if (module.getDuration() == LessonDuration.SINGLE) {
                        if ((value.size() - currentScheduleIndex.get()) < 0) {
                            value.get(currentScheduleIndex.get()).setModule(module);
                            currentScheduleIndex.getAndIncrement();
                        }
                    } else if (module.getDuration() == LessonDuration.DOUBLE) {
                        if ((value.size() - currentScheduleIndex.get()) < 1) {
                            value.get(currentScheduleIndex.get()).setModule(module);
                            value.get(currentScheduleIndex.get() + 1).setModule(module);
                            currentScheduleIndex.getAndAdd(2);
                        }
                    } else {
                        if ((value.size() - currentScheduleIndex.get()) < 2) {
                            value.get(currentScheduleIndex.get()).setModule(module);
                            value.get(currentScheduleIndex.get() + 1).setModule(module);
                            value.get(currentScheduleIndex.get() + 2).setModule(module);
                            currentScheduleIndex.getAndAdd(3);
                        }
                    }
                });
            });
            possibleSchedules.add(schedules);
        });
        return possibleSchedules;
    }

    private List<List<SchoolModule>> createAllModuleCombinations(List<SchoolModule> modules, int capacity) {
        return shuffle(modules, 0);
    }

    public List<List<SchoolModule>> shuffle(List<SchoolModule> modules, int depth) {
        final List<List<SchoolModule>> moduleList = new ArrayList<>();
        if (depth == modules.size()) {
            moduleList.add(modules);
            return moduleList;
        } else {
            for (int i = depth; i < modules.size(); i++) {
                SchoolModule temp = modules.get(depth);
                modules.set(depth, modules.get(i));
                modules.set(i, temp);
                moduleList.addAll(shuffle(modules, depth + 1));
                temp = modules.get(depth);
                modules.set(depth, modules.get(i));
                modules.set(i, temp);
            }
        }
        return moduleList;
    }



    private List<SchoolModule> createModuleListForFullCapacity(List<SchoolModule> modules, int capacity) {
        final List<SchoolModule> modulesList = new ArrayList<>(modules);
        int difference = capacity - modulesList.size();
        while (difference > 0) {
            modulesList.add(SchoolModule.builder()
                    .name("free")
                    .duration(LessonDuration.SINGLE)
                    .build());
            difference--;
        }
        return modulesList;
    }
}
