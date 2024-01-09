package com.dk.stundenplaner.mapper;

import com.dk.stundenplaner.entity.ModuleEntity;
import com.dk.stundenplaner.model.LessonDuration;
import com.dk.stundenplaner.model.SchoolModule;

public class ModuleEntityMapper {

    public static ModuleEntity mapToEntity(SchoolModule module) {
        final ModuleEntity entity = new ModuleEntity();
        entity.setName(module.getName());
        entity.setShortcut(module.getShortcut());
        entity.setDuration(module.getDuration() != null ? module.getDuration().name() : "DOUBLE");
        return entity;
    }

    public static SchoolModule mapToModel(ModuleEntity entity) {
        return SchoolModule.builder()
                .name(entity.getName())
                .shortcut(entity.getShortcut())
                .duration(LessonDuration.valueOf(entity.getDuration()))
                .build();
    }
}
