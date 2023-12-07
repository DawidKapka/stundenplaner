package com.dk.stundenplaner.repository;

import com.dk.stundenplaner.model.Teacher;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TeacherRespository {

    public void saveTeachers(List<Teacher> teachers) {
        System.out.println(teachers);
    }

    public List<Teacher> readTeachers() {
        return new ArrayList<>();
    }
}
