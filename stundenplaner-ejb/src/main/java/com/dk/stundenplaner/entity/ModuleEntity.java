package com.dk.stundenplaner.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "module")
@NamedQuery(name = "findAllModules", query = "SELECT m FROM ModuleEntity m")
@NamedQuery(name = "findModuleByShortcut", query = "SELECT m FROM ModuleEntity m WHERE m.shortcut = :shortcut")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ModuleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "moduleId")
    private int id;
    @Column(name = "moduleName")
    private String name;
    @Column(name = "shortcut")
    private String shortcut;
    @Column(name = "duration")
    private String duration;
    @ManyToMany(mappedBy = "modules")
    private List<TeacherEntity> teachers;
    @ManyToMany(mappedBy = "modules")
    private List<ClassEntity> classes;

    public ModuleEntity() {
    }

    public ModuleEntity(String name, String shortcut, String duration) {
        this.name = name;
        this.shortcut = shortcut;
        this.duration = duration;
    }
}
