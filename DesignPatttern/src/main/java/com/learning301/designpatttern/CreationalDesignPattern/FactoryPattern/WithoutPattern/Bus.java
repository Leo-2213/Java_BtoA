package com.learning301.designpatttern.CreationalDesignPattern.FactoryPattern.WithoutPattern;

/**
 * Bus - WITHOUT Factory Pattern
 * 
 * Client directly creates instances using 'new Bus()'
 * No factory to encapsulate creation logic
 * Client must know about concrete class
 */
public class Bus implements TransportMedium{
    
    /**
     * Bus start implementation
     */
    @Override
    public void start() {
        System.out.println("Starting bus");
    }
}