package com.example.backend.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LearningPath {
    private String id;
    private String userId;
    private String targetRoleId;
    private List<String> pendingModules;
    private List<String> completedModules;
}