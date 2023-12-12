package com.dk.stundenplaner.repository;

import com.dk.stundenplaner.model.SchoolModule;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ModuleRepository {

    public void saveModules(List<SchoolModule> modules) {
        System.out.println(modules);
    }

    public List<SchoolModule> readModules() {
        return new ArrayList<>();
    }
}
