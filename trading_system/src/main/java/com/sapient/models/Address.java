package com.sapient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String houseNo;
    private String streetName;
    private String city;
    private String state;
    private String pinCode;
}
