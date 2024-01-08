package com.dk.stundenplaner.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "teacher")
@NamedQuery(name = "findAllTeachers", query = "SELECT t FROM TeacherEntity t")
@NamedQuery(name = "findTeacher", query = "SELECT e FROM TeacherEntity e WHERE e.id = :id")
@Getter
@Setter
@EqualsAndHashCode
@ToString
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
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "teacher_weekday", joinColumns = @JoinColumn(name = "teacherId"))
    @Column(name = "weekday")
    private List<String> availableDays;
    @ManyToMany
    @JoinTable(
            name = "teacher_modules",
            joinColumns = @JoinColumn(name = "fk_teacherId"),
            inverseJoinColumns = @JoinColumn(name = "fk_moduleId")
    )
    private List<ModuleEntity> modules;

    public TeacherEntity() {
    }

    public TeacherEntity(String firstname, String lastname, String shortcut, String pensum, List<String> availableDays) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.shortcut = shortcut;
        this.pensum = pensum;
        this.availableDays = availableDays;
    }
}