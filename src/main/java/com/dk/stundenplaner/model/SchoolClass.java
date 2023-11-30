package com.dk.stundenplaner.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SchoolClass extends AbstractModel {
    private String name;
    @Builder.Default
    private List<Weekday> daysUnavailable = new ArrayList<>();
    @Builder.Default
    private List<String> modules = new ArrayList<>();
}
