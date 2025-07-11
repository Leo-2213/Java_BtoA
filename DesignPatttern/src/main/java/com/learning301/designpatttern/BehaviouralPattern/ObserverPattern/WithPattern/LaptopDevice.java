package com.learning301.designpatttern.BehaviouralPattern.ObserverPattern.WithPattern;

/**
 * LaptopDevice - Concrete implementation of the Observer interface
 * This class represents a laptop device that displays temperature updates
 * It demonstrates how different types of observers can respond to the same notification
 * in their own specific way.
 */
public class LaptopDevice implements Observer {

    // Identifier for this specific observer
    private String observerType;

    /**
     * Constructor that sets the identifier for this observer
     * 
     * @param observerType A string identifier for this laptop device
     */
    public LaptopDevice(String observerType)
    {
        this.observerType = observerType;
    }

    /**
     * Implementation of the updateTemp method from Observer interface
     * Defines how this specific observer responds to temperature updates
     * 
     * @param temp The updated temperature value from the subject
     */
    public void updateTemp(float temp){
        System.out.println("Temperature updated to "+temp+" in Laptop" + observerType);
    }
}
