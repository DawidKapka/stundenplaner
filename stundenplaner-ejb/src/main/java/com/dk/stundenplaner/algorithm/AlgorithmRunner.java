package com.dk.stundenplaner.algorithm;

import java.util.*;

import com.dk.stundenplaner.algorithm.step.*;
import com.dk.stundenplaner.model.*;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
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

    public Map<Teacher, List<ScheduleEntry>> run() {
        final Map<Teacher, List<ScheduleEntry>> teacherSchedules = new CreateEmptyTeacherSchedulesStep().create(teachers);
        final Map<Teacher, List<ScheduleEntry>> teachersWithModules = new AssignModulesToTeachersStep().assign(teacherSchedules, classes, modules);
        //final Map<Teacher, List<ScheduleEntry>> schedulesWithDays = new AssignScheduleToDaysStep().assign(teachersWithModules, classes);
        return teachersWithModules;
    }

    private void createCombinationMaps() {
        availableDaysForClassesMap = MapAvailableDaysToClassStep.map(classes);
        availableDaysForTeachersMap = MapAvailableDaysToTeacherStep.map(teachers);
        classModulesMap = MapModulesToClassStep.map(classes, modules);
        teacherModulesMap = MapModulesToTeacherStep.map(teachers, modules);
    }

}
