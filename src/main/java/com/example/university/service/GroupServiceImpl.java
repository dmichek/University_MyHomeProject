package com.example.university.service;

import com.example.university.dto.AllGroupResponseDto;
import com.example.university.dto.GroupAddRequestDto;
import com.example.university.dto.SingleGroupResponseDto;
import com.example.university.dto.StudentResponseDto;
import com.example.university.entity.Group;
import com.example.university.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Override
    public void addGroup(GroupAddRequestDto groupAddRequestDto) {

        Group group = new Group();
        group.setName(groupAddRequestDto.getName());
        group.setCreateAt(LocalDate.now());

        groupRepository.save(group);

    }

    @Override
    public List<AllGroupResponseDto> getAllGroup() {

        List<Group> groups = groupRepository.findAll();

        List<AllGroupResponseDto> allGroupResponseDtos = new ArrayList<>();

        for (Group group : groups) {
            AllGroupResponseDto allGroupResponseDto = new AllGroupResponseDto();
            allGroupResponseDto.setGroupId(group.getId());
            allGroupResponseDto.setGroupName(group.getName());
            allGroupResponseDto.setStudentQuantity(group.getStudents().size());
            allGroupResponseDtos.add(allGroupResponseDto);
        }


        return allGroupResponseDtos;
    }

    @Override
    public SingleGroupResponseDto getGroupById(Integer id) {

        Optional<Group> optionalGroup = groupRepository.findById(id);

        Group group = optionalGroup.orElseThrow(() -> {
            throw new IllegalStateException("группа с ID: " + id + " не найдена");
        });

        SingleGroupResponseDto singleGroupResponseDto = new SingleGroupResponseDto();
        singleGroupResponseDto.setGroupId(group.getId());
        singleGroupResponseDto.setGroupName(group.getName());
        singleGroupResponseDto.setStudents(group.getStudents().stream()
                .map(student -> {
                    StudentResponseDto studentResponseDto = new StudentResponseDto();
                    studentResponseDto.setStudentId(student.getId());
                    studentResponseDto.setName(student.getName());
                    studentResponseDto.setCreateAt(student.getCreateAt());
                    return studentResponseDto;
                }).collect(Collectors.toList()));


        return singleGroupResponseDto;
    }


}
