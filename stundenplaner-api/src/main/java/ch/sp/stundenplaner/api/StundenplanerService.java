package ch.sp.stundenplaner.api;

import com.dk.stundenplaner.scheduler.Scheduler;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class StundenplanerService {

    @Inject
    private Scheduler scheduler;

    public String createSchedule() {
        return scheduler.test();
    }
}
