package com.designPattern.designPattern.decorator;

public class NonVegFood extends FoodDecorator
{
    public NonVegFood(Food newFood)
    {
        super(newFood);
    }

    public String prepareFood()
    {
        return super.prepareFood() + "with roasted chicken and chicken curry ";
    }

    public double foodPrice()
    {
        return super.foodPrice() + 150.0;
    }
}
