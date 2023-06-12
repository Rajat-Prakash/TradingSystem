package com.sapient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    private int bankId;
    private String bankName;
    private int nostroAccountInformation;
    private int deskCode;
    private String treasuryInformation;
}
