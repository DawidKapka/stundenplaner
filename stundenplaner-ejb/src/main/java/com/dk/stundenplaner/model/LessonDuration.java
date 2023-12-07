package com.dk.stundenplaner.model;

public enum LessonDuration {
    SINGLE(1),
    DOUBLE(2),
    TRIPLE(3);

    private int length;

    LessonDuration(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
