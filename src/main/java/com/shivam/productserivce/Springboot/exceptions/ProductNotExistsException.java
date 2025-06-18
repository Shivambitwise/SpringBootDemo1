package com.shivam.productserivce.Springboot.exceptions;

public class ProductNotExistsException extends Exception{

    public ProductNotExistsException(String message)
    {
        super(message);
    }

}
