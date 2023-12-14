package ch.sp.stundenplaner.api;

import ch.sp.stundenplaner.api.module.ModuleResource;
import ch.sp.stundenplaner.api.room.RoomResource;
import ch.sp.stundenplaner.api.schoolclass.ClassResource;
import ch.sp.stundenplaner.api.teacher.TeacherResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/api/v1")
public class StundenplanerApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(StundenplanerResource.class);
        classes.add(TeacherResource.class);
        classes.add(ModuleResource.class);
        classes.add(ClassResource.class);
        classes.add(RoomResource.class);
        return classes;
    }
}
