package com.learning301.designpatttern.CreationalDesignPattern.FactoryPattern.WithoutPattern;

/**
 * Bike - WITHOUT Factory Pattern
 * 
 * Client directly creates instances using 'new Bike()'
 * No factory to encapsulate creation logic
 * Client must know about concrete class
 */
public class Bike implements TransportMedium{
    
    /**
     * Bike start implementation
     */
    @Override
    public void start() {
        System.out.println("Starting Bike");
    }
}