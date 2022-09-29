package com.example.university.service;

import com.example.university.dto.StudentAddRequestDto;
import com.example.university.entity.Group;
import com.example.university.entity.Student;
import com.example.university.repository.GroupRepository;
import com.example.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    GroupRepository groupRepository;

    @Override
    public void addStudent(StudentAddRequestDto studentAddRequestDto) {

        Group group = groupRepository.getById(studentAddRequestDto.getGroupId());

        Student student = new Student();
        student.setName(studentAddRequestDto.getName());
        student.setCreateAt(LocalDate.now());
        student.setGroup(group);

        studentRepository.save(student);
    }
}
