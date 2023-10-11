package com.blogpost.blogpost.exception;

public class PostNotFoundException extends RuntimeException  //Cause its an unchecked exception
{

    //what is happening below is called constructor overloading
    public PostNotFoundException()
    {

        super();
    }

    public PostNotFoundException(String msg)
    {

        super(msg);
    }
}
