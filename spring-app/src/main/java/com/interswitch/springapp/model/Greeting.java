package com.interswitch.springapp.model;

public class Greeting {

    public String sayHello(String name)
    {
        return String.format("%s %s", "Welcome to Spring boot", name);

    }
    public void destroy()
    {
        System.out.println(this.getClass().getName() + "is beign destroyed");
    }

    public void init()
    {
        System.out.println(this.getClass().getName() + "is being initialized");
    }

}