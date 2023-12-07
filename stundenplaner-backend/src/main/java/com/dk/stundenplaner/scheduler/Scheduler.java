package com.dk.stundenplaner.scheduler;

import com.dk.stundenplaner.algorithm.AlgorithmRunner;
import com.dk.stundenplaner.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scheduler {

    public void createSchedule() {
        final List<ScheduleEntry> schedule = createEmptyWeekSchedule();
        final List<SchoolModule> modules = JsonReader.readModules();
        final List<SchoolClass> classes = JsonReader.readClasses();
        final List<Teacher> teachers = JsonReader.readTeachers();
        final List<Room> rooms = JsonReader.readRooms();
        runAlgorithm(schedule, modules, classes, teachers, rooms);
    }

    private List<ScheduleEntry> createEmptyWeekSchedule() {
        final List<ScheduleEntry> schedule = new ArrayList<>();
        for (Weekday day : Weekday.values()) {
            final List<ScheduleEntry> entries = Arrays.asList(
                    ScheduleEntry.builder().weekday(day).build(),
                    ScheduleEntry.builder().weekday(day).build(),
                    ScheduleEntry.builder().weekday(day).build(),
                    ScheduleEntry.builder().weekday(day).build()
            );
            schedule.addAll(entries);
        }
        return schedule;
    }

    private void runAlgorithm(List<ScheduleEntry> schedule, List<SchoolModule> modules, List<SchoolClass> classes, List<Teacher> teachers, List<Room> rooms) {
        final AlgorithmRunner runner = new AlgorithmRunner(classes, modules, teachers, schedule, rooms);
        runner.run();
    }
}


