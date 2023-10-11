package com.rkProductManager.productManager.exception;

public class ProductNotFoundException extends RuntimeException  //Cause its an unchecked exception
{

    //what is happening below is called constructor overloading
    public ProductNotFoundException()
    {

        super();
    }

    public ProductNotFoundException(String msg)
    {

        super(msg);
    }
}
