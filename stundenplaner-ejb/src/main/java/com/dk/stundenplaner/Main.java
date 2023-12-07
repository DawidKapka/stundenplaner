package com.dk.stundenplaner;

import com.dk.stundenplaner.scheduler.Scheduler;

public class Main {
    public static void main(String[] args) {
        final Scheduler scheduler = new Scheduler();
        scheduler.createSchedule();
    }
}