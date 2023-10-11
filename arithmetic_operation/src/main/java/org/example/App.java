package org.example;

class Calc
{
    public int add(int a, int b )
    {
        return a+b;
    }

    public int divide(int a, int b )
    {
        return a/b;
    }

    public int multiply(int a, int b )
    {
        return a*b;
    }

    public int subtract(int a, int b )
    {
        return a-b;
    }

}
public class App

    {
    public static void main( String[] args )
        {
//        System.out.println( "Hello World!" );

        Calc calc = new Calc();
        int addResult = calc.add(4,2);
            System.out.println(addResult);

    }
}




