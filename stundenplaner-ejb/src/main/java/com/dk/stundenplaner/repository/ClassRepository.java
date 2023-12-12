package com.dk.stundenplaner.repository;

import com.dk.stundenplaner.model.SchoolClass;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClassRepository {

    public void saveClasses(List<SchoolClass> classes) {
        System.out.println(classes);
    }

    public List<SchoolClass> readClasses() {
        return new ArrayList<>();
    }
}
