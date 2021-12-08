package com.switchfully.eurder.customexceptions;

public class OrderDateException extends RuntimeException {

    public OrderDateException() {
        this("Error occurred while calculating order date (check ItemGroup dates). ");
    }

    public OrderDateException(String message) {
        super(message);
    }
}
