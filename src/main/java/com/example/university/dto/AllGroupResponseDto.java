package com.example.university.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllGroupResponseDto {

    Integer groupId;
    String groupName;
    int studentQuantity;



}
