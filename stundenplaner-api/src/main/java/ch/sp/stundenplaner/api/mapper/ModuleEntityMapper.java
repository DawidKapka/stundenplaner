package ch.sp.stundenplaner.api.mapper;

import com.dk.stundenplaner.entity.ModuleEntity;
import com.dk.stundenplaner.model.LessonDuration;
import com.dk.stundenplaner.model.SchoolModule;

public class ModuleEntityMapper {

    public static ModuleEntity mapToEntity(SchoolModule module) {
        final ModuleEntity entity = new ModuleEntity();
        entity.setName(module.getModuleName());
        entity.setShortcut(module.getShortcut());
        entity.setDuration(module.getDuration().name());
        return entity;
    }

    public static SchoolModule mapToModel(ModuleEntity entity) {
        return SchoolModule.builder()
                .moduleName(entity.getName())
                .shortcut(entity.getShortcut())
                .duration(LessonDuration.valueOf(entity.getDuration()))
                .build();
    }
}
