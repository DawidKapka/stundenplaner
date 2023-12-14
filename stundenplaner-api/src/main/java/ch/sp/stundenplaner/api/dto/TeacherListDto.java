package ch.sp.stundenplaner.api.dto;

import com.dk.stundenplaner.model.Teacher;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeacherListDto extends AbstractDto {
    @Builder.Default
    private List<Teacher> teachers = new ArrayList<>();

    public static TeacherListDto fromJson(String json) {
        return fromJson(json, TeacherListDto.class);
    }
}
