package com.sapient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calendar {
    private int calendarId;
    private List<Event>events;
    private LocalDate currentDate;
    private LocalDate selectedDate;
    private List<LocalDate> govtHolidaysCurrentYear;
    private List<LocalDate> marketHolidaysCurrentYear;
}
