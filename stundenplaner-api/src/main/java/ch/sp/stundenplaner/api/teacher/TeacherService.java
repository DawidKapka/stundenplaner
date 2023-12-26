package ch.sp.stundenplaner.api.teacher;

import ch.sp.stundenplaner.api.dto.TeacherListDto;
import ch.sp.stundenplaner.api.mapper.TeacherEntityMapper;
import com.dk.stundenplaner.entity.TeacherEntity;
import com.dk.stundenplaner.repository.TeacherRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TeacherService {

    @Inject
    private TeacherRepository respository;

    public void saveTeachers(TeacherListDto dto) {
        final List<TeacherEntity> entities = dto.getTeachers()
                .stream()
                .map(TeacherEntityMapper::mapToEntity)
                .toList();
        respository.saveTeachers(entities);
    }

    public TeacherListDto readTeachers() {
        final List<TeacherEntity> teachers = respository.readTeachers();
        return TeacherListDto.builder()
                .teachers(teachers.stream()
                        .map(TeacherEntityMapper::mapToModel)
                        .toList())
                .build();
    }
}
