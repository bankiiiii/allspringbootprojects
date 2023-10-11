package com.designPattern.designPattern.decorator;

import com.designPattern.designPattern.decorator.Food;
import com.designPattern.designPattern.decorator.FoodDecorator;

public class ChineseFood extends FoodDecorator {

    public ChineseFood(Food newFood)
    {
        super(newFood);
    }

    public String prepareFood()
    {
        return super.prepareFood() + "with fried rice and manchurian ";
    }

    public double foodPrice()
    {
        return super.foodPrice() + 65.0;
    }
}
