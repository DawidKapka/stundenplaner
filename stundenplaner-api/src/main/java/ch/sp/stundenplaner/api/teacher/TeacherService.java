package ch.sp.stundenplaner.api.teacher;

import ch.sp.stundenplaner.api.dto.TeacherListDto;
import com.dk.stundenplaner.model.Teacher;
import com.dk.stundenplaner.repository.TeacherRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TeacherService {

    @Inject
    private TeacherRepository respository;

    public void saveTeachers(TeacherListDto dto) {
        respository.saveTeachers(dto.getTeachers());
    }

    public TeacherListDto readTeachers() {
        final List<Teacher> teachers = respository.readTeachers();
        return TeacherListDto.builder()
                .teachers(teachers)
                .build();
    }
}
