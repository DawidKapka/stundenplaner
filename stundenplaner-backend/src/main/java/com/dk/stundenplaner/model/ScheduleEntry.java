package com.dk.stundenplaner.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ScheduleEntry extends AbstractModel {
    private SchoolModule module;
    private Teacher teacher;
    private SchoolClass assignedSchoolClass;
    private Weekday weekday;
    private Room room;
}
