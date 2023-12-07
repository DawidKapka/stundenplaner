package com.dk.stundenplaner.algorithm.step;

import com.dk.stundenplaner.model.SchoolModule;
import com.dk.stundenplaner.model.Teacher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapModulesToTeacherStep {

    public static Map<Teacher, List<SchoolModule>> map(List<Teacher> teachers, List<SchoolModule> modules) {
        final Map<Teacher, List<SchoolModule>> teacherModulesMap = new HashMap<>();
        teachers.forEach(teacher -> {
            final List<SchoolModule> teacherModules = teacher.getModules().stream()
                    .map(module -> modules.stream()
                            .filter(m -> m.getModuleName().equals(module))
                            .findFirst()
                            .orElse(null))
                    .toList();
            teacherModulesMap.put(teacher, teacherModules);
        });
        return teacherModulesMap;
    }
}
