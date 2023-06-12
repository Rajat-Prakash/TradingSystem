package com.sapient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private int id;
    private String description;
    private LocalDate date;
}
