package com.dk.stundenplaner.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SchoolModule extends AbstractModel {
    private String moduleName;
    private LessonDuration duration;
}
