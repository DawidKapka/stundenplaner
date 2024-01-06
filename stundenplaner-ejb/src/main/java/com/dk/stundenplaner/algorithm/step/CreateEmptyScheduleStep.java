package com.dk.stundenplaner.algorithm.step;

import com.dk.stundenplaner.model.ScheduleEntry;
import com.dk.stundenplaner.model.Weekday;

import java.util.*;

public class CreateEmptyScheduleStep {

    public Map<Weekday, List<ScheduleEntry>> create() {
        final Map<Weekday, List<ScheduleEntry>> schedule = new HashMap<>();
        Arrays.stream(Weekday.values()).forEach(weekday -> {
            final List<ScheduleEntry> entries = new ArrayList<>(Arrays.asList(
                    ScheduleEntry.builder().build(),
                    ScheduleEntry.builder().build(),
                    ScheduleEntry.builder().build(),
                    ScheduleEntry.builder().build()
            ));
            schedule.put(weekday, entries);
        });
        return schedule;
    }
}
