package com.dk.stundenplaner.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Room extends AbstractModel {
    private int id;
    private String name;
    private Roomtype type;
}
