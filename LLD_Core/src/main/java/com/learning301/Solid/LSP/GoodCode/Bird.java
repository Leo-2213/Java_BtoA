package com.learning301.Solid.LSP.GoodCode;

/**
 * Base Bird interface that defines behavior common to all birds.
 * This follows LSP by including only methods that all birds can implement correctly.
 */
public interface Bird {
    /**
     * All birds can eat, so this method is in the base interface
     */
    void eat();
}
