package com.sapient.exceptions;

public class InvalidCountryCode extends Exception{
    public InvalidCountryCode(String s)
    {
        super(s);
    }
}