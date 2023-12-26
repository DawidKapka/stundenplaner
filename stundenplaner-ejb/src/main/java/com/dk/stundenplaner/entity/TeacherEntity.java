package com.dk.stundenplaner.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teacher")
@NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM TeacherEntity t")
@NamedQuery(name = "Teacher.findTeacher", query = "SELECT e FROM TeacherEntity e WHERE "
        + "e.firstname = :firstname AND e.lastname = :lastname AND e.shortcut = :shortcut AND e.pensum = :pensum")
@Getter
@Setter
public class TeacherEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "teacherId")
    private int id;

    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "shortcut")
    private String shortcut;
    @Column(name = "pensum")
    private String pensum;

    public TeacherEntity() {
    }

    public TeacherEntity(String firstname, String lastname, String shortcut, String pensum) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.shortcut = shortcut;
        this.pensum = pensum;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherEntity teacherEntity = (TeacherEntity) o;
        return id == teacherEntity.id && Objects.equals(firstname, teacherEntity.firstname) && Objects.equals(lastname, teacherEntity.lastname) && Objects.equals(shortcut, teacherEntity.shortcut) && Objects.equals(pensum, teacherEntity.pensum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, shortcut, pensum);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", shortcut='" + shortcut + '\'' +
                ", pensum='" + pensum + '\'' +
                '}';
    }
}