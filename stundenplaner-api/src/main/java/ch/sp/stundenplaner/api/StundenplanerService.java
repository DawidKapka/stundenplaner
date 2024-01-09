package ch.sp.stundenplaner.api;

import com.dk.stundenplaner.model.ScheduleEntry;
import com.dk.stundenplaner.model.Teacher;
import com.dk.stundenplaner.scheduler.Scheduler;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Map;

@ApplicationScoped
public class StundenplanerService {

    @Inject
    private Scheduler scheduler;

    public Map<Teacher, List<ScheduleEntry>> createSchedule() {
        return scheduler.createSchedule();
    }
}
