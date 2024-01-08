package com.example.dto;


import lombok.Data;

import java.time.LocalDate;
@Data
public class YoungestEldestWorker {
    private String type;
    private String name;
    private LocalDate birthday;
}
