package com.deliverygogo.JDBC1.Exception;

public class IllegalLengthException extends IllegalArgumentException{

    static final String YELLOW = "\u001B[33m";
    static final String RESET = "\u001B[0m";
    public IllegalLengthException(String message) {
        super(YELLOW + message + RESET);
    }

}