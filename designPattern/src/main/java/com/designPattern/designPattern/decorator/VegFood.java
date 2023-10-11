package com.designPattern.designPattern.decorator;

public class VegFood implements Food {

    public String prepareFood()
    {
        return "Veg food";
    }

    public double foodPrice()
    {
        return 50.0;
    }
}
