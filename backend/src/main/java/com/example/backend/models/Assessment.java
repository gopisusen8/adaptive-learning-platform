package com.example.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assessment {
    private String id;
    private String userId;
    private String roleId;
    private int score;
    private String segmentAssigned;
}