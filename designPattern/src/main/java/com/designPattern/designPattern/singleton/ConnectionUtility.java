package com.designPattern.designPattern.singleton;

public enum ConnectionUtility {

    INSTANCE;

    public String getValue() {
        return "This is a test Value";
    }

}
