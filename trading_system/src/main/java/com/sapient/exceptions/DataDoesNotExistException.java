package com.sapient.exceptions;

public class DataDoesNotExistException extends Exception{
    public DataDoesNotExistException(String s)
    {
        super(s);
    }
}