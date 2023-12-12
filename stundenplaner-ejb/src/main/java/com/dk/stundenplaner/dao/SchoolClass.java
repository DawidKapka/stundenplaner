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
@NamedQuery(name = "SchoolClass.findAll", query = "SELECT e FROM SchoolClass e")
@NamedQuery(name = "SchoolClass.findSchoolClass", query = "SELECT e FROM SchoolClass e WHERE "
        + "e.className = :className")
public class SchoolClass implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "classId")
    private int id;

    @Column(name = "className")
    private String className;

    public SchoolClass() {
    }

    public SchoolClass(String className) {
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolClass that = (SchoolClass) o;
        return id == that.id && Objects.equals(className, that.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, className);
    }

    @Override
    public String toString() {
        return "SchoolClass{" +
                "id=" + id +
                '}';
    }
}