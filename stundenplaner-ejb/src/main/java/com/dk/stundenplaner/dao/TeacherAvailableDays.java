package com.dk.stundenplaner.dao;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "class")
@NamedQuery(name = "TeacherAvailableDays.findAll", query = "SELECT e FROM TeacherAvailableDays e")
@NamedQuery(name = "TeacherAvailableDays.findTeacherAvailableDays", query = "SELECT e FROM TeacherAvailableDays e WHERE "
        + "e.fk_teacherId = :fk_teacherId AND e.day = :day")
public class TeacherAvailableDays implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "teacherAvailableDayId")
    private int id;

    @Column(name = "fk_teacherId")
    private String fk_teacherId;
    @Column(name = "day")
    private String day;

    public TeacherAvailableDays() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFk_teacherId() {
        return fk_teacherId;
    }

    public void setFk_teacherId(String fk_teacherId) {
        this.fk_teacherId = fk_teacherId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherAvailableDays that = (TeacherAvailableDays) o;
        return id == that.id && Objects.equals(fk_teacherId, that.fk_teacherId) && Objects.equals(day, that.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fk_teacherId, day);
    }

    @Override
    public String toString() {
        return "TeacherAvailableDays{" +
                "fk_teacherId='" + fk_teacherId + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}