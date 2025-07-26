package com.learning301.designpatttern.CreationalDesignPattern.FactoryPattern.WithoutPattern;

/**
 * TransportMedium Interface - WITHOUT Factory Pattern
 * 
 * Same interface as WithPattern but used differently
 * Client directly instantiates concrete classes
 * No factory to encapsulate object creation
 */
public interface TransportMedium {
    /**
     * Start the transport medium
     */
    public void start();
}
