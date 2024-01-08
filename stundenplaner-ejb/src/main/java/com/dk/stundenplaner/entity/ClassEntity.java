package com.dk.stundenplaner.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "class")
@NamedQuery(name = "findAllClasses", query = "SELECT c FROM ClassEntity c")
@NamedQuery(name = "findClass", query = "SELECT c FROM ClassEntity c WHERE c.id = :id")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ClassEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "classId")
    private int id;

    @Column(name = "className")
    private String name;
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "class_weekday", joinColumns = @JoinColumn(name = "classId"))
    @Column(name = "weekday")
    private List<String> daysUnavailable;
    @ManyToMany
    @JoinTable(
            name = "class_modules",
            joinColumns = @JoinColumn(name = "fk_classId"),
            inverseJoinColumns = @JoinColumn(name = "fk_moduleId")
    )
    private List<ModuleEntity> modules;

    public ClassEntity() {

    }

    public ClassEntity(String name) {
        this.name = name;
    }
}
