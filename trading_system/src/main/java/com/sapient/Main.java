package com.sapient;

import com.sapient.exceptions.InvalidCurrencyException;
import com.sapient.utility.CurrencyUtility;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InvalidCurrencyException {
        CurrencyUtility curr = new CurrencyUtility();
        try {
            curr.performCurrencyOperations();
        } catch (IOException e) {
            throw new InvalidCurrencyException("Invalid Currency");
        }
    }
}