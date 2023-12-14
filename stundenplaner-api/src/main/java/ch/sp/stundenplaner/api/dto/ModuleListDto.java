package ch.sp.stundenplaner.api.dto;

import com.dk.stundenplaner.model.SchoolModule;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ModuleListDto extends AbstractDto {
    @Builder.Default
    final List<SchoolModule> modules = new ArrayList<>();

    public static ModuleListDto fromJson(String json) {
        return fromJson(json, ModuleListDto.class);
    }
}
