package com.example.university.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "name")
    String name;


    @Column(name = "create_at")
    LocalDate createAt;

    @ManyToOne
    @JoinColumn(name = "group_id")
    Group group;
}
