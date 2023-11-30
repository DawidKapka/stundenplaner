package com.dk.stundenplaner.algorithm.step;

import com.dk.stundenplaner.model.SchoolClass;
import com.dk.stundenplaner.model.SchoolModule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapModulesToClassStep {

    public static Map<SchoolClass, List<SchoolModule>> map(List<SchoolClass> classes, List<SchoolModule> modules) {
        final Map<SchoolClass, List<SchoolModule>> modulesForClass = new HashMap<>();
        classes.forEach(clazz -> {
            final List<SchoolModule> classModules = modules.stream()
                    .filter(module -> clazz.getModules().contains(module.getModuleName()))
                    .toList();
            modulesForClass.put(clazz, classModules);
        });
        return modulesForClass;
    }
}
