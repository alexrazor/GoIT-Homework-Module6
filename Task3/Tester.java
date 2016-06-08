package com.goit.gojava.module3.Task3;


import java.util.HashMap;
import java.util.Map;

public class Tester {
    public static void main(String[] args) throws InstrumentNotFoundException {
        // initializing musical instruments and adding them to ArrayList inStock
        Guitar g = new Guitar();
        Piano p = new Piano();
        Tube t = new Tube();
        MusicShop mShop = new MusicShop();
        mShop.setInStock(g);
        mShop.setInStock(p);
        mShop.setInStock(t);

        //Checking what we actually have in stock after initializing
        System.out.println("In stock");
        for (MusicalInstruments m: mShop.getInStock()){
            System.out.println("In stock: "+m.getName()+", amount: "+m.getAmount());
        }

        // creating new order for 7 guitars and 2 tubes
        Map<String, Integer> order1 = new HashMap<>();
        order1.put("guitar", 7);
        order1.put("tube",2);

        // sending order1 to music shop
        mShop.prepareInstruments(order1);

        //Checking what left in stock after order1
        System.out.println("After order1");
        for (MusicalInstruments m: mShop.getInStock()){
            System.out.println("In stock: "+m.getName()+", amount: "+m.getAmount());
        }

        //creating order2 for 1 piano
        Map<String, Integer> order2 = new HashMap<>();
        order2.put("piano",1);

        //sending order2 to music shop
        mShop.prepareInstruments(order2);

        //Checking what left in stock after order2
        System.out.println("After order2");
        for (MusicalInstruments m: mShop.getInStock()){
            System.out.println("In stock: "+m.getName()+", amount: "+m.getAmount());

        }
        /*
        // check for wrong instrument in the order
        Map<String, Integer> wrongOrder = new HashMap<>();
        wrongOrder.put("violin",12);
        mShop.prepareInstruments(wrongOrder);
        */

        // creating order3 for  1 фортепиано, 8 гитар и 6 труб
        Map<String,Integer> order3 = new HashMap<>();
        order3.put("piano",1);
        order3.put("guitar",8);
        order3.put("tube",6);

        //sending order3 to music shop
        mShop.prepareInstruments(order3);




        //Checking what left in stock after order3
        System.out.println("After order3");
        for (MusicalInstruments m: mShop.getInStock()){
            System.out.println("In stock: "+m.getName()+", amount: "+m.getAmount());

        }
    }
}
