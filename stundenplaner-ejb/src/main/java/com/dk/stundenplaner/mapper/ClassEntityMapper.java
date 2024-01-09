package com.dk.stundenplaner.mapper;

import com.dk.stundenplaner.entity.ClassEntity;
import com.dk.stundenplaner.entity.ModuleEntity;
import com.dk.stundenplaner.model.SchoolClass;
import com.dk.stundenplaner.model.Weekday;

import java.util.List;

public class ClassEntityMapper {

    public static ClassEntity mapToEntity(SchoolClass schoolClass, List<ModuleEntity> modules) {
        final ClassEntity entity = new ClassEntity();
        entity.setId(schoolClass.getId());
        entity.setName(schoolClass.getName());
        entity.setDaysUnavailable(schoolClass.getDaysUnavailable().stream()
                .map(Enum::name)
                .toList());
        entity.setModules(modules);
        entity.setBasislehrjahr(schoolClass.isBasislehrjahr());
        return entity;
    }

    public static SchoolClass mapToModel(ClassEntity entity) {
        return SchoolClass.builder()
                .id(entity.getId())
                .name(entity.getName())
                .daysUnavailable(entity.getDaysUnavailable().stream()
                        .map(Weekday::valueOf)
                        .toList())
                .modules(entity.getModules().stream()
                        .map(ModuleEntity::getShortcut)
                        .toList())
                .basislehrjahr(entity.isBasislehrjahr())
                .build();
    }
}
