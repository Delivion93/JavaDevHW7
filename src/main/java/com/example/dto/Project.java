package com.example.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Project {
    private int clientId;
    private LocalDate startDate;
    private LocalDate finishDate;

    public Project(int clientId, LocalDate startDate, LocalDate finishDate) {
        this.clientId = clientId;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
}
