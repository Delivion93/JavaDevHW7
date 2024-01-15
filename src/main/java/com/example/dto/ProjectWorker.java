package com.example.dto;

import lombok.Data;

@Data
public class ProjectWorker {
    private int projectId;
    private int workerId;

    public ProjectWorker(int projectId, int workerId) {
        this.projectId = projectId;
        this.workerId = workerId;
    }
}
