package com.dk.stundenplaner.algorithm.util;

import com.dk.stundenplaner.model.SchoolClass;
import com.dk.stundenplaner.model.SchoolModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModuleUtil {

    public static List<SchoolModule> accumulateAllModules(Map<SchoolClass, List<SchoolModule>> classModuleMap) {
        final List<SchoolModule> modules = new ArrayList<>();
        classModuleMap.forEach((key, value) -> modules.addAll(value));
        return modules;
    }
}
