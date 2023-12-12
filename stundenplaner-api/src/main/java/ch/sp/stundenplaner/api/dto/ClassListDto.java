package ch.sp.stundenplaner.api.dto;

import com.dk.stundenplaner.model.SchoolClass;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClassListDto extends AbstractDto {
    @Builder.Default
    final List<SchoolClass> classes = new ArrayList<>();

    public static ClassListDto fromJson(String json) {
        return fromJson(json, ClassListDto.class);
    }
}
