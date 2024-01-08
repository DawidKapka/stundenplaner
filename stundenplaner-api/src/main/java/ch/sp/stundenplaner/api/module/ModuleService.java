package ch.sp.stundenplaner.api.module;

import ch.sp.stundenplaner.api.dto.ModuleListDto;
import ch.sp.stundenplaner.api.mapper.ModuleEntityMapper;
import com.dk.stundenplaner.entity.ModuleEntity;
import com.dk.stundenplaner.model.SchoolModule;
import com.dk.stundenplaner.repository.ModuleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ModuleService {

    @Inject
    private ModuleRepository repository;

    public void saveModules(ModuleListDto dto) {
        repository.saveModules(dto.getModules().stream()
                .map(ModuleEntityMapper::mapToEntity)
                .toList());
    }

    public ModuleListDto readModules() {
        final List<SchoolModule> modules = repository.readModules().stream()
                .map(ModuleEntityMapper::mapToModel)
                .toList();
        return ModuleListDto.builder()
                .modules(modules)
                .build();
    }

    public SchoolModule readModule(String shortcut) {
        final ModuleEntity module = repository.findModuleByShortcut(shortcut);
        return ModuleEntityMapper.mapToModel(module);
    }

    public void deleteModule(String shortcut) {
        repository.deleteModule(shortcut);
    }
}
