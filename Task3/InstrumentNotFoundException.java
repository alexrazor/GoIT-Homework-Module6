package com.goit.gojava.module3.Task3;


public class InstrumentNotFoundException extends Exception {
    InstrumentNotFoundException(){
        System.out.println("[error:] ordered instrument not inStock");
    }
}
