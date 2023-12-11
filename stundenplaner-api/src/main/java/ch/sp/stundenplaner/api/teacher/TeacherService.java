package ch.sp.stundenplaner.api.teacher;

import com.dk.stundenplaner.model.Teacher;
import com.dk.stundenplaner.repository.TeacherRespository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TeacherService {

    @Inject
    private TeacherRespository respository;

    public void saveTeachers(List<com.dk.stundenplaner.dao.Teacher> teachers) {
        respository.saveTeachers(teachers);
    }

    public List<com.dk.stundenplaner.dao.Teacher> readTeachers() {
        return respository.readTeachers();
    }
}
