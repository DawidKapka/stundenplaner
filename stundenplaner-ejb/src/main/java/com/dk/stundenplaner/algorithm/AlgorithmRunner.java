package com.dk.stundenplaner.algorithm;

import java.util.*;

import com.dk.stundenplaner.algorithm.step.*;
import com.dk.stundenplaner.algorithm.util.ModuleUtil;
import com.dk.stundenplaner.algorithm.util.TeacherUtil;
import com.dk.stundenplaner.model.*;

public class AlgorithmRunner {

    private final List<SchoolClass> classes;
    private final List<SchoolModule> modules;
    private final List<Teacher> teachers;
    private final List<ScheduleEntry> schedule;
    private final List<Room> rooms;
    private Map<SchoolClass, List<Weekday>> availableDaysForClassesMap;
    private Map<Teacher, List<Weekday>> availableDaysForTeachersMap;
    private Map<SchoolClass, List<SchoolModule>> classModulesMap;
    private Map<Teacher, List<SchoolModule>> teacherModulesMap;

    public AlgorithmRunner(List<SchoolClass> classes, List<SchoolModule> modules, List<Teacher> teachers, List<ScheduleEntry> schedule, List<Room> rooms) {
        this.classes = classes;
        this.modules = modules;
        this.teachers = teachers;
        this.schedule = schedule;
        this.rooms = rooms;
        createCombinationMaps();
    }

    /*
        1. Get List of all modules
        2. Get Map of all class candidates for each module
     */

    public Map<Weekday, List<ScheduleEntry>> run() {
        final Map<Weekday, List<ScheduleEntry>> schedule = new CreateEmptyScheduleStep().create();
        final Map<Teacher, List<ScheduleEntry>> teacherSchedules = new CreateEmptyTeacherSchedulesStep().create(teachers);
        final List<SchoolModule> allModules = ModuleUtil.accumulateAllModules(classModulesMap);

        return schedule;
    }

    private void createCombinationMaps() {
        availableDaysForClassesMap = MapAvailableDaysToClassStep.map(classes);
        availableDaysForTeachersMap = MapAvailableDaysToTeacherStep.map(teachers);
        classModulesMap = MapModulesToClassStep.map(classes, modules);
        teacherModulesMap = MapModulesToTeacherStep.map(teachers, modules);
    }

}
