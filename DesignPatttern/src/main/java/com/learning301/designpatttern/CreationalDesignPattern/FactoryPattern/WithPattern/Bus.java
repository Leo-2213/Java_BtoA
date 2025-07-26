package com.learning301.designpatttern.CreationalDesignPattern.FactoryPattern.WithPattern;

/**
 * Bus - Concrete Product in Factory Pattern
 * 
 * Implements TransportMedium interface with bus-specific behavior
 * Created by TransportFactory when "bus" type is requested
 * Client doesn't create this directly - factory handles instantiation
 */
public class Bus implements TransportMedium {
    
    /**
     * Bus-specific implementation of start method
     * Different behavior from Car and Bike but same interface
     */
    @Override
    public void start() {
        System.out.println("Starting Bus: Diesel engine warming up, doors closing");
    }
}
