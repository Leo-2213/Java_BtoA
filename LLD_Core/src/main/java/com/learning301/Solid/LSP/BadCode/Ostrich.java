package com.learning301.Solid.LSP.BadCode;

/**
 * Ostrich implementation that violates the Liskov Substitution Principle.
 * Since ostriches cannot fly in reality, this class is forced to implement
 * the fly() method in a way that either:
 * 1. Gives misleading output ("Ostrich cannot fly")
 * 2. Throws an exception (commented out code)
 * 
 * Both approaches violate LSP because an Ostrich cannot be substituted
 * for a Bird without affecting program behavior.
 */
public class Ostrich implements Bird {

    /**
     * This implementation violates LSP because ostriches cannot fly.
     * The method either gives misleading output or would throw an exception.
     */
    @Override
    public void fly() {
        System.out.println("Ostrich cannot fly");
        // Uncommenting the line below would make the violation even more obvious:
        // throw new RuntimeException("Ostrich cannot fly");
    }

    /**
     * Implementation of the eat method
     */
    @Override
    public void eat() {
        System.out.println("Ostrich eats");
    }
}
