package com.designPattern.designPattern.singleton;

public class ConnectionTest {

    public static void main(String[] args) {
        String result = ConnectionUtility.INSTANCE.getValue();
        System.out.println(result);
    }
}
