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
@Table(name = "class_modules")
@NamedQuery(name = "ClassModules.findAll", query = "SELECT e FROM ClassModules e")
@NamedQuery(name = "ClassModules.findClassModules", query = "SELECT e FROM ClassModules e WHERE "
        + "e.fk_classId = :fk_classId AND e.fk_moduleId = :fk_moduleId")
public class ClassModules implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "classModuleId")
    private int id;

    @Column(name = "fk_classId")
    private String fk_classId;
    @Column(name = "fk_moduleId")
    private String fk_moduleId;

    public ClassModules() {
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

    public String getFk_moduleId() {
        return fk_moduleId;
    }

    public void setFk_moduleId(String fk_moduleId) {
        this.fk_moduleId = fk_moduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassModules that = (ClassModules) o;
        return id == that.id && Objects.equals(fk_classId, that.fk_classId) && Objects.equals(fk_moduleId, that.fk_moduleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fk_classId, fk_moduleId);
    }

    @Override
    public String toString() {
        return "ClassModules{" +
                "fk_classId='" + fk_classId + '\'' +
                ", fk_moduleId='" + fk_moduleId + '\'' +
                '}';
    }
}