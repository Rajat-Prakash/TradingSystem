package com.sapient.exceptions;

public class InvalidUserIdException extends Exception{
    public InvalidUserIdException(String s)
    {
        super(s);
    }
}