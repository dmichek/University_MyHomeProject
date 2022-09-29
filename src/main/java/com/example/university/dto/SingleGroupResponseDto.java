package com.example.university.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingleGroupResponseDto {

    Integer groupId;
    String groupName;
    List<StudentResponseDto> students;


}
