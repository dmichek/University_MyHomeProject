package com.example.university.service;

import com.example.university.dto.AllGroupResponseDto;
import com.example.university.dto.GroupAddRequestDto;
import com.example.university.dto.SingleGroupResponseDto;

import java.util.List;

public interface GroupService {


    void addGroup(GroupAddRequestDto groupAddRequestDto);

    List<AllGroupResponseDto> getAllGroup();

    SingleGroupResponseDto getGroupById(Integer id);
}
