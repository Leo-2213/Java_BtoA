package com.learning301.Solid.LSP.GoodCode;

/**
 * Ostrich implementation that can eat but cannot fly.
 * This follows LSP by implementing only the Bird interface and not FlyingBirds,
 * as ostriches cannot fly in reality.
 */
public class Ostrich implements Bird {
    /**
     * Implementation of the eat method for Ostrich
     */
    @Override
    public void eat() {
        System.out.println("Ostrich eats");
    }
    
    // Note: No fly method is implemented since ostriches cannot fly
}
