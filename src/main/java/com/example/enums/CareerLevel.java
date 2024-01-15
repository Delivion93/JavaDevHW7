package com.example.enums;


import lombok.Getter;

@Getter
public enum CareerLevel {
    TRAINEE("Trainee"),
    JUNIOR("Junior"),
    MIDDLE("Middle"),
    SENIOR("Senior");
    private final String description;
    CareerLevel(String description) {
        this.description = description;
    }

}
