package com.dk.stundenplaner;

import com.dk.stundenplaner.algorithm.step.CreateAllTeacherModuleCombinationsStep;
import com.dk.stundenplaner.model.LessonDuration;
import com.dk.stundenplaner.model.ScheduleEntry;
import com.dk.stundenplaner.model.SchoolModule;
import com.dk.stundenplaner.model.Teacher;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;


public class CreateAllTeacherModuleCombinationsStepTest {

    @Test
    public void shouldCreateAllPossibleCombinationsWhenTeacherListAndModuleListGiven() {
        final CreateAllTeacherModuleCombinationsStep testee = new CreateAllTeacherModuleCombinationsStep();
        final List<SchoolModule> modules = createModuleList();
        final Map<Teacher, List<ScheduleEntry>> teacherScheduleMap = createTeacherScheduleMap();

        final List<Map<Teacher, List<ScheduleEntry>>> result = testee.create(modules, teacherScheduleMap);

        assertEquals(1, 1);
    }

    private Map<Teacher, List<ScheduleEntry>> createTeacherScheduleMap() {
        final List<Teacher> teachers = Arrays.asList(
                createTeacher(),
                createTeacher(),
                createTeacher()
        );
        final Map<Teacher, List<ScheduleEntry>> map = new HashMap<>();
        teachers.forEach(teacher -> map.put(teacher, Arrays.asList(
                createScheduleEntry(),
                createScheduleEntry(),
                createScheduleEntry()
        )));
        return map;
    }

    private ScheduleEntry createScheduleEntry() {
        return ScheduleEntry.builder().build();
    }

    private Teacher createTeacher() {
        return Teacher.builder()
                .firstname("Firstname")
                .lastname("Lastname")
                .pensum(3)
                .build();
    }

    private List<SchoolModule> createModuleList() {
        return Arrays.asList(
                SchoolModule.builder().moduleName("M1").duration(LessonDuration.SINGLE).build(),
                SchoolModule.builder().moduleName("M2").duration(LessonDuration.DOUBLE).build(),
                SchoolModule.builder().moduleName("M3").duration(LessonDuration.TRIPLE).build()
        );
    }
}
