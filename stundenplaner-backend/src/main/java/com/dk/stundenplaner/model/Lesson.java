package com.dk.stundenplaner.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Lesson extends AbstractModel {
    private LessonDuration duration;

}
