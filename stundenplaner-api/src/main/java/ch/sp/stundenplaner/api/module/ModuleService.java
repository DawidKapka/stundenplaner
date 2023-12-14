package ch.sp.stundenplaner.api.module;

import ch.sp.stundenplaner.api.dto.ModuleListDto;
import com.dk.stundenplaner.model.SchoolModule;
import com.dk.stundenplaner.repository.ModuleRepository;
import jakarta.inject.Inject;

import java.util.List;

public class ModuleService {

    @Inject
    private ModuleRepository repository;

    public void saveModules(ModuleListDto dto) {
        repository.saveModules(dto.getModules());
    }

    public ModuleListDto readModules() {
        final List<SchoolModule> modules = repository.readModules();
        return ModuleListDto.builder()
                .modules(modules)
                .build();
    }
}
