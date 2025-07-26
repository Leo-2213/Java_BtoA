package com.learning301.designpatttern.CreationalDesignPattern.FactoryPattern.WithoutPattern;

/**
 * Car - WITHOUT Factory Pattern
 * 
 * Client directly creates instances using 'new Car()'
 * No factory to encapsulate creation logic
 * Client must know about concrete class
 */
public class Car implements TransportMedium{

    /**
     * Car start implementation
     */
    @Override
    public void start() {
        System.out.println("Starting Car");
    }
}
