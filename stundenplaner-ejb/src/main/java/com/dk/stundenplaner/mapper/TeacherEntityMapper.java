package com.dk.stundenplaner.mapper;

import com.dk.stundenplaner.entity.ModuleEntity;
import com.dk.stundenplaner.entity.TeacherEntity;
import com.dk.stundenplaner.model.Teacher;
import com.dk.stundenplaner.model.Weekday;

import java.util.ArrayList;
import java.util.List;

public class TeacherEntityMapper {

    public static TeacherEntity mapToEntity(Teacher teacher, List<ModuleEntity> modules) {
        final TeacherEntity entity = new TeacherEntity();
        entity.setId(teacher.getId());
        entity.setFirstname(teacher.getFirstname());
        entity.setLastname(teacher.getLastname());
        entity.setShortcut(teacher.getShortcut());
        entity.setPensum(String.valueOf(teacher.getPensum()));
        entity.setAvailableDays(teacher.getAvailableDays()
                .stream()
                .map(Enum::name)
                .toList());
        entity.setModules(modules);
        return entity;
    }

    public static Teacher mapToModel(TeacherEntity entity) {
        return Teacher.builder()
                .availableDays(new ArrayList<>())
                .firstname(entity.getFirstname())
                .lastname(entity.getLastname())
                .shortcut(entity.getShortcut())
                .pensum(Integer.parseInt(entity.getPensum()))
                .id(entity.getId())
                .availableDays(entity.getAvailableDays()
                        .stream()
                        .map(Weekday::valueOf)
                        .toList())
                .modules(entity.getModules().stream()
                        .map(m -> m.getShortcut())
                        .toList())
                .build();
    }
}
