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
@NamedQuery(name = "Teacher.findAll", query = "SELECT e FROM Teacher e")
@NamedQuery(name = "Teacher.findTeacher", query = "SELECT e FROM Teacher e WHERE "
        + "e.firstname = :firstname AND e.lastname = :lastname AND e.shortcut = :shortcut AND e.pensum = :pensum")
public class Teacher implements Serializable {
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

    public Teacher() {
    }

    public Teacher(String firstname, String lastname, String shortcut, String pensum) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.shortcut = shortcut;
        this.pensum = pensum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getlastname() {
        return lastname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getShortcut() {
        return shortcut;
    }

    public String getPensum() {
        return pensum;
    }

    public void setPensum(String pensum) {
        this.pensum = pensum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id && Objects.equals(firstname, teacher.firstname) && Objects.equals(lastname, teacher.lastname) && Objects.equals(shortcut, teacher.shortcut) && Objects.equals(pensum, teacher.pensum);
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