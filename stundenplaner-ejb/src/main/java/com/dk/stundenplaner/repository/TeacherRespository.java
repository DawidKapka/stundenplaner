package com.dk.stundenplaner.repository;

import com.dk.stundenplaner.dao.TeacherDao;
import com.dk.stundenplaner.dao.Teacher;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TeacherRespository {
    TeacherDao teacherDao = new TeacherDao();

    public void saveTeachers(List<Teacher> teachers) {
        teachers.forEach(teacher -> {teacherDao.createTeacher(teacher);
        });
    }

    public List<com.dk.stundenplaner.dao.Teacher> readTeachers() {
        return teacherDao.readAllTeachers();
    }
}
