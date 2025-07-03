package com.learning301.Solid.LSP.GoodCode;

/**
 * Cookoo implementation that can both eat and fly.
 * This follows LSP by implementing the FlyingBirds interface,
 * as cuckoos are birds that can actually fly.
 */
public class Cookoo implements FlyingBirds {
    /**
     * Implementation of the fly method for Cookoo
     */
    @Override
    public void fly() {
        System.out.println("Cookoo is flying");
    }
    
    /**
     * Implementation of the eat method for Cookoo
     */
    @Override
    public void eat() {
        System.out.println("Cookoo eats");
    }
}
