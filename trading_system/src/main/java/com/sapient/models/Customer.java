package com.sapient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int customerID;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Address address;
    private int phoneNumber;
    private String state;
    private int pinCode;
    private Country country;
}
