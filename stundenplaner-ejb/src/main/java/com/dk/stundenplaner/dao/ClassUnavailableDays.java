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
@Table(name = "class_unavailable_days")
@NamedQuery(name = "ClassUnavailableDays.findAll", query = "SELECT e FROM ClassUnavailableDays e")
@NamedQuery(name = "ClassUnavailableDays.findClassUnavailableDays", query = "SELECT e FROM ClassUnavailableDays e WHERE "
        + "e.fk_classId = :fk_classId AND e.day = :day")
public class ClassUnavailableDays implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "classUnavailableDayId")
    private int id;

    @Column(name = "fk_classId")
    private String fk_classId;
    @Column(name = "day")
    private String day;

    public ClassUnavailableDays() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFk_classId() {
        return fk_classId;
    }

    public void setFk_classId(String fk_classId) {
        this.fk_classId = fk_classId;
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
        ClassUnavailableDays that = (ClassUnavailableDays) o;
        return id == that.id && Objects.equals(fk_classId, that.fk_classId) && Objects.equals(day, that.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fk_classId, day);
    }

    @Override
    public String toString() {
        return "ClassUnavailableDays{" +
                "fk_classId='" + fk_classId + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}