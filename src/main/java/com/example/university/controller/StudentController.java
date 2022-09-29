package com.example.university.controller;

import com.example.university.dto.StudentAddRequestDto;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public void add(@RequestBody StudentAddRequestDto studentAddRequestDto) {

        studentService.addStudent(studentAddRequestDto);

    }

}


