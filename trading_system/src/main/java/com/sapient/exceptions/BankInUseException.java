package com.sapient.exceptions;

public class BankInUseException extends Exception{
    public BankInUseException(String s)
    {
        super(s);
    }
}
