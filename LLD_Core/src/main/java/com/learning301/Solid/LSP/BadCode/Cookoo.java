package com.learning301.Solid.LSP.BadCode;

/**
 * Cookoo implementation in the bad design.
 * For Cookoo, implementing the Bird interface is not problematic
 * since cuckoos can actually fly. However, this design still participates
 * in an LSP violation due to the overall hierarchy.
 */
public class Cookoo implements Bird {
    /**
     * Cookoo can fly, so this implementation is valid
     */
    @Override
    public void fly() {
        System.out.println("Cookoo is flying");
    }
    
    /**
     * Implementation of the eat method
     */
    @Override
    public void eat() {
        System.out.println("Cookoo eats");
    }
}
