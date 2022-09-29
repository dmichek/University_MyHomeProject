package com.example.university.controller;

import com.example.university.dto.AllGroupResponseDto;
import com.example.university.dto.GroupAddRequestDto;
import com.example.university.dto.SingleGroupResponseDto;
import com.example.university.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/groups")
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping
    public void add(@RequestBody GroupAddRequestDto groupAddRequestDto) {

        groupService.addGroup(groupAddRequestDto);

    }

    @GetMapping
    public List<AllGroupResponseDto> getAllGroup() {
        return groupService.getAllGroup();
    }

    @GetMapping(path = "/{id}")
    public SingleGroupResponseDto getGroupById(@PathVariable Integer id) {
        return groupService.getGroupById(id);
    }

}
