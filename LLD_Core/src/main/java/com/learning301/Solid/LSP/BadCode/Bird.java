package com.learning301.Solid.LSP.BadCode;

/**
 * Bird interface that violates the Liskov Substitution Principle.
 * This interface assumes all birds can fly, which is not true in reality.
 * This forces non-flying birds like Ostrich to implement a fly method
 * that they cannot properly fulfill.
 */
public interface Bird {
    /**
     * Not all birds can fly, so this method violates LSP
     * when implemented by non-flying birds
     */
    void fly();
    
    /**
     * All birds can eat
     */
    void eat();
}
