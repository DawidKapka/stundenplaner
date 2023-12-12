package com.dk.stundenplaner.scheduler;

import com.dk.stundenplaner.mapper.JsonToModelMapper;
import com.dk.stundenplaner.model.Room;
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
        put(Teacher.class, "/src/test-teachers.json");
        put(SchoolModule.class, "/src/test-modules.json");
        put(SchoolClass.class, "/src/test-classes.json");
        put(Room.class, "/src/test-rooms.json");
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

    public static List<Room> readRooms() {
        final String path = pathMap.get(Room.class);
        String jsonFile = readFile(path);
        return JsonToModelMapper.mapToModel(jsonFile, Room.class);
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
