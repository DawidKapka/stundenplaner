package com.dk.stundenplaner.scheduler;

import com.dk.stundenplaner.algorithm.AlgorithmRunner;
import com.dk.stundenplaner.mapper.ClassEntityMapper;
import com.dk.stundenplaner.mapper.ModuleEntityMapper;
import com.dk.stundenplaner.mapper.RoomEntityMapper;
import com.dk.stundenplaner.mapper.TeacherEntityMapper;
import com.dk.stundenplaner.model.*;
import com.dk.stundenplaner.repository.ClassRepository;
import com.dk.stundenplaner.repository.ModuleRepository;
import com.dk.stundenplaner.repository.RoomRepository;
import com.dk.stundenplaner.repository.TeacherRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class Scheduler {

    @Inject
    private ModuleRepository moduleRepository;
    @Inject
    private ClassRepository classRepository;
    @Inject
    private TeacherRepository teacherRepository;
    @Inject
    private RoomRepository roomRepository;

    public Map<Teacher, List<ScheduleEntry>> createSchedule() {
        final List<ScheduleEntry> schedule = createEmptyWeekSchedule();
        final List<SchoolModule> modules = moduleRepository.readModules().stream().map(ModuleEntityMapper::mapToModel).toList();
        final List<SchoolClass> classes = classRepository.readClasses().stream().map(ClassEntityMapper::mapToModel).toList();
        final List<Teacher> teachers = teacherRepository.readTeachers().stream().map(TeacherEntityMapper::mapToModel).toList();
        final List<Room> rooms = roomRepository.readRooms().stream().map(RoomEntityMapper::mapToModel).toList();
        return runAlgorithm(schedule, modules, classes, teachers, rooms);
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

    private Map<Teacher, List<ScheduleEntry>> runAlgorithm(List<ScheduleEntry> schedule, List<SchoolModule> modules, List<SchoolClass> classes, List<Teacher> teachers, List<Room> rooms) {
        final AlgorithmRunner runner = new AlgorithmRunner(classes, modules, teachers, schedule, rooms);
        return runner.run();
    }
}


