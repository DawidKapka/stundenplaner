package com.dk.stundenplaner.scheduler;

import com.dk.stundenplaner.mapper.JsonToModelMapper;
import com.dk.stundenplaner.model.SchoolClass;
import com.dk.stundenplaner.model.SchoolModule;
import com.dk.stundenplaner.model.Teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonReader {

    private static Map<Class<?>, String> pathMap = new HashMap<>() {{
        put(Teacher.class, "/test-teachers.json");
        put(SchoolModule.class, "/test-modules.json");
        put(SchoolClass.class, "/test-classes.json");
    }};

    public static List<SchoolModule> readModules() {
        final String path = pathMap.get(SchoolModule.class);
        String jsonFile = readFile(path);
        return JsonToModelMapper.mapToModel(jsonFile, SchoolModule.class);
    }

    public static List<SchoolClass> readClasses() {
        final String path = pathMap.get(SchoolClass.class);
        String jsonFile = readFile(path);
        return JsonToModelMapper.mapToModel(jsonFile, SchoolClass.class);
    }

    public static List<Teacher> readTeachers() {
        final String path = pathMap.get(Teacher.class);
        String jsonFile = readFile(path);
        return JsonToModelMapper.mapToModel(jsonFile, Teacher.class);
    }

    private static String readFile(String url) {
        try {
            final InputStream inputStream = JsonReader.class.getResourceAsStream(url);
            final InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            final BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder file = new StringBuilder();
            for (String line; (line = reader.readLine()) != null;) {
                file.append(line);
            }
            return file.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
