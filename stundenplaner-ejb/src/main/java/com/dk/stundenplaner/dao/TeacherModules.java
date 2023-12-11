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
@NamedQuery(name = "TeacherModules.findAll", query = "SELECT e FROM TeacherModules e")
@NamedQuery(name = "TeacherModules.findTeacherModules", query = "SELECT e FROM TeacherModules e WHERE "
        + "e.fk_teacherId = :fk_teacherId AND e.fk_moduleId = :fk_moduleId")
public class TeacherModules implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "teacherModuleId")
    private int id;

    @Column(name = "fk_teacherId")
    private String fk_teacherId;
    @Column(name = "fk_moduleId")
    private String fk_moduleId;

    public TeacherModules() {
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
        TeacherModules that = (TeacherModules) o;
        return id == that.id && Objects.equals(fk_teacherId, that.fk_teacherId) && Objects.equals(fk_moduleId, that.fk_moduleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fk_teacherId, fk_moduleId);
    }

    @Override
    public String toString() {
        return "TeacherModules{" +
                "fk_teacherId='" + fk_teacherId + '\'' +
                ", fk_moduleId='" + fk_moduleId + '\'' +
                '}';
    }
}