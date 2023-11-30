package com.dk.stundenplaner.algorithm;

import java.util.List;
import java.util.Map;

import com.dk.stundenplaner.algorithm.step.MapAvailableDaysToClassStep;
import com.dk.stundenplaner.algorithm.step.MapModulesToTeacherStep;
import com.dk.stundenplaner.model.*;

public class AlgorithmRunner {

    private final List<SchoolClass> classes;
    private final List<SchoolModule> modules;
    private final List<Teacher> teachers;
    private final List<ScheduleEntry> schedule;

    public AlgorithmRunner(List<SchoolClass> classes, List<SchoolModule> modules, List<Teacher> teachers, List<ScheduleEntry> schedule) {
        this.classes = classes;
        this.modules = modules;
        this.teachers = teachers;
        this.schedule = schedule;
    }

    public List<ScheduleEntry> run() {
        final Map<SchoolClass, List<Weekday>> availableDaysForClassesMap = MapAvailableDaysToClassStep.map(classes);
        final Map<Teacher, List<SchoolModule>> teacherModulesMap = MapModulesToTeacherStep.map(teachers, modules);
        System.out.println(teacherModulesMap);
        return schedule;
    }
}
