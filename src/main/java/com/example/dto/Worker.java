package com.example.dto;

import com.example.enums.CareerLevel;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Worker {
    private String name;
    private LocalDate dateOfBirth;
    private CareerLevel level;
    private int salary;

    public Worker(String name, LocalDate dateOfBirth, CareerLevel level, int salary) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.level = level;
        this.salary = salary;
    }
}
