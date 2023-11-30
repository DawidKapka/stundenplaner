package com.dk.stundenplaner.algorithm.step;

import com.dk.stundenplaner.model.SchoolClass;
import com.dk.stundenplaner.model.Weekday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapAvailableDaysToClassStep {

    public static Map<SchoolClass, List<Weekday>> map(List<SchoolClass> classes) {
        final Map<SchoolClass, List<Weekday>> availableDaysForClass = new HashMap<>();
        classes.forEach(schoolClass -> {
            final List<Weekday> availableDays = Arrays.stream(Weekday.values())
                    .filter(day -> !schoolClass.getDaysUnavailable().contains(day))
                    .toList();
            availableDaysForClass.put(schoolClass, availableDays);
        });
        return availableDaysForClass;
    }
}
