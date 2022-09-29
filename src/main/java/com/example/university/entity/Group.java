package com.example.university.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "univer_groups")
@Getter
@Setter
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "name")
    String name;


    @Column(name = "create_at")
    LocalDate createAt;

    @OneToMany(mappedBy = "group")
    List<Student> students;


}
