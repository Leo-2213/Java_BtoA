package com.learning301.designpatttern.CreationalDesignPattern.FactoryPattern.WithPattern;

/**
 * Bike - Concrete Product in Factory Pattern
 * 
 * Implements TransportMedium interface with bike-specific behavior
 * Created by TransportFactory when "bike" type is requested
 * Client doesn't create this directly - factory handles instantiation
 */
public class Bike implements TransportMedium {
    
    /**
     * Bike-specific implementation of start method
     * Different behavior from Car but same interface
     */
    @Override
    public void start() {
        System.out.println("Starting Bike: Kick start, throttle ready");
    }
}
