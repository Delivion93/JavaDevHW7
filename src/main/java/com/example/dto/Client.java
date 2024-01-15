package com.example.dto;

import lombok.Data;

@Data
public class Client {
    private String name;

    public Client(String name) {
        this.name = name;
    }
}
