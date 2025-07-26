package com.learning301.designpatttern.CreationalDesignPattern.FactoryPattern.WithPattern;

/**
 * Car - Concrete Product in Factory Pattern
 * 
 * Implements TransportMedium interface with car-specific behavior
 * Created by TransportFactory when "car" type is requested
 * Client doesn't create this directly - factory handles instantiation
 */
public class Car implements TransportMedium {

    /**
     * Car-specific implementation of start method
     * Each concrete product has its own behavior
     */
    @Override
    public void start() {
        System.out.println("Starting Car: Engine ignition, gear engaged");
    }
}
