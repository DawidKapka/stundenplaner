package ch.sp.stundenplaner.api.teacher;

import ch.sp.stundenplaner.api.dto.TeacherListDto;
import ch.sp.stundenplaner.api.mapper.ModuleEntityMapper;
import ch.sp.stundenplaner.api.mapper.TeacherEntityMapper;
import com.dk.stundenplaner.entity.ModuleEntity;
import com.dk.stundenplaner.entity.TeacherEntity;
import com.dk.stundenplaner.model.Teacher;
import com.dk.stundenplaner.repository.ModuleRepository;
import com.dk.stundenplaner.repository.TeacherRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TeacherService {

    @Inject
    private TeacherRepository teacherRepository;
    @Inject
    private ModuleRepository moduleRepository;

    public void saveTeachers(TeacherListDto dto) {
        final List<TeacherEntity> entities = dto.getTeachers()
                .stream()
                .map(teacher -> TeacherEntityMapper.mapToEntity(teacher, getModules(teacher)))
                .toList();
        teacherRepository.saveTeachers(entities);
    }

    private List<ModuleEntity> getModules(Teacher teacher) {
        return teacher.getModules().stream()
                .map(module -> moduleRepository.findModuleByShortcut(module))
                .toList();
    }

    public TeacherListDto readTeachers() {
        final List<TeacherEntity> teachers = teacherRepository.readTeachers();
        return TeacherListDto.builder()
                .teachers(teachers.stream()
                        .map(TeacherEntityMapper::mapToModel)
                        .toList())
                .build();
    }

    public Teacher readTeacher(String id) {
        final TeacherEntity teacherEntity = teacherRepository.readTeacher(id);
        return TeacherEntityMapper.mapToModel(teacherEntity);
    }

    public void deleteTeacher(String id) {
        teacherRepository.deleteTeacher(id);
    }
}
