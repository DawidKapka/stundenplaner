package ch.sp.stundenplaner.api.mapper;

import com.dk.stundenplaner.entity.TeacherEntity;
import com.dk.stundenplaner.model.Teacher;

import java.util.ArrayList;

public class TeacherEntityMapper {

    public static TeacherEntity mapToEntity(Teacher teacher) {
        final TeacherEntity entity = new TeacherEntity();
        entity.setFirstname(teacher.getFirstname());
        entity.setLastname(teacher.getLastname());
        entity.setShortcut(teacher.getShortcut());
        entity.setPensum(String.valueOf(teacher.getPensum()));
        return entity;
    }

    public static Teacher mapToModel(TeacherEntity entity) {
        return Teacher.builder()
                // TODO: finish idk
                .availableDays(new ArrayList<>())
                .firstname(entity.getFirstname())
                .lastname(entity.getLastname())
                .shortcut(entity.getShortcut())
                .pensum(Integer.parseInt(entity.getPensum()))
                .build();
    }
}
