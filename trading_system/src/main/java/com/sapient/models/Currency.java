package com.sapient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
    private int currencyId;
    private String currencyDescription;
    private int currencyCode;
    private Symbol currencySymbol;
    private String countryUsingCurrency;
}
