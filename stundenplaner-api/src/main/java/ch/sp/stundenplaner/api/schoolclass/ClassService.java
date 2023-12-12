package ch.sp.stundenplaner.api.schoolclass;

import ch.sp.stundenplaner.api.dto.ClassListDto;
import com.dk.stundenplaner.model.SchoolClass;
import com.dk.stundenplaner.repository.ClassRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ClassService {

    @Inject
    private ClassRepository repository;

    public void saveClasses(ClassListDto dto) {
        repository.saveClasses(dto.getClasses());
    }

    public ClassListDto readClasses() {
        final List<SchoolClass> classes = repository.readClasses();
        return ClassListDto.builder()
                .classes(classes)
                .build();
    }
}
