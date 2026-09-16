package com.example.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String uid;
    private String email;
    private String currentRoleId;
    private String competencyLevel;
}