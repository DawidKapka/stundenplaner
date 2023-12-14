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
@Table(name = "module")
@NamedQuery(name = "SchoolModule.findAll", query = "SELECT e FROM SchoolModule e")
@NamedQuery(name = "SchoolModule.findSchoolModule", query = "SELECT e FROM SchoolModule e WHERE "
        + "e.moduleName = :moduleName AND e.duration = :duration")
public class SchoolModule implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "moduleId")
    private int id;

    @Column(name = "moduleName")
    private String moduleName;
    @Column(name = "duration")
    private String duration;

    public SchoolModule() {
    }

    public SchoolModule(String moduleName, String duration) {
        this.moduleName = moduleName;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getduration() {
        return duration;
    }

    public void setduration(String duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolModule that = (SchoolModule) o;
        return id == that.id && Objects.equals(moduleName, that.moduleName) && Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moduleName, duration);
    }

    @Override
    public String toString() {
        return "SchoolModule{" +
                "moduleName='" + moduleName + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}