package com.chinasofti.design;

public class GargageBox {
    private static GargageBox instance = new GargageBox();

    public static GargageBox getInstance(){
        return instance;
    }
    private GargageBox(){}
}
