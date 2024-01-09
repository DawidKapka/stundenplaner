package ch.sp.stundenplaner.api.schoolclass;

import ch.sp.stundenplaner.api.dto.ClassListDto;
import com.dk.stundenplaner.mapper.ClassEntityMapper;
import com.dk.stundenplaner.entity.ClassEntity;
import com.dk.stundenplaner.entity.ModuleEntity;
import com.dk.stundenplaner.model.SchoolClass;
import com.dk.stundenplaner.repository.ClassRepository;
import com.dk.stundenplaner.repository.ModuleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ClassService {

    @Inject
    private ClassRepository classRepository;
    @Inject
    private ModuleRepository moduleRepository;

    public void saveClasses(ClassListDto dto) {
        classRepository.saveClasses(dto.getClasses().stream()
                .map(clazz -> ClassEntityMapper.mapToEntity(clazz, getModules(clazz)))
                .toList());
    }

    private List<ModuleEntity> getModules(SchoolClass clazz) {
        return clazz.getModules().stream()
                .map(module -> moduleRepository.findModuleByShortcut(module))
                .toList();
    }

    public ClassListDto readClasses() {
        final List<ClassEntity> classes = classRepository.readClasses();
        return ClassListDto.builder()
                .classes(classes.stream()
                        .map(ClassEntityMapper::mapToModel)
                        .toList())
                .build();
    }


    public SchoolClass readClass(String id) {
        final ClassEntity classEntity = classRepository.readClass(id);
        return ClassEntityMapper.mapToModel(classEntity);
    }

    public void deleteTeacher(String id) {
        classRepository.deleteClass(id);
    }
}
