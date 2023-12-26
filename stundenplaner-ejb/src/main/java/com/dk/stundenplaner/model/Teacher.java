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
public class Teacher extends AbstractModel {
    private String firstname;
    private String lastname;
    private String shortcut;
    private int pensum;
    @Builder.Default
    private List<Weekday> availableDays = new ArrayList<>();
    @Builder.Default
    private List<String> modules = new ArrayList<>();
}
