package ch.sp.stundenplaner.api;

import ch.sp.stundenplaner.api.teacher.TeacherResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/api")
public class StundenplanerApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(StundenplanerResource.class);
        classes.add(TeacherResource.class);
        return classes;
    }
}
