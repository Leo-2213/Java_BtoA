package com.learning301.designpatttern.BehaviouralPattern.ObserverPattern.WithPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * WeatherStation - Concrete implementation of the Subject interface
 * This class represents the subject being observed (the weather station)
 * It maintains the temperature state and notifies observers when it changes.
 */
public class WeatherStation implements Subject{

    // The state that will be observed (temperature)
    private float temperature = 34.5F;
    
    // List to keep track of all registered observers
    private final List<Observer> observerList;

    /**
     * Constructor initializes an empty list of observers
     */
    WeatherStation() {
        this.observerList = new ArrayList<>();
    }

    /**
     * Updates the temperature and notifies all observers of the change
     * This is the primary state change method that triggers notifications
     * 
     * @param temperature The new temperature value
     */
    public void setTemperature(float temperature) {
        System.out.println("Setting the temperature : " + temperature);
        this.temperature = temperature;
        notifyObservers();
    }

    /**
     * Returns the current temperature
     * 
     * @return The current temperature value
     */
    public float getTemperature() {
        return temperature;
    }

    /**
     * Implementation of the notifyObservers method from Subject interface
     * Iterates through all registered observers and updates them with the current temperature
     */
    @Override
    public void notifyObservers()
    {
        observerList.forEach(observer -> observer.updateTemp(this.temperature));
    }

    /**
     * Implementation of the registerObserver method from Subject interface
     * Adds a new observer to the list of registered observers
     * 
     * @param observer The observer to be registered
     */
    @Override
    public void registerObserver(Observer observer){
        System.out.println("Registering the observer");
        observerList.add(observer);
    }

    /**
     * Implementation of the removeObserver method from Subject interface
     * Removes an observer from the list of registered observers
     * 
     * @param observer The observer to be removed
     */
    @Override
    public void removeObserver(Observer observer){
        System.out.println("Removing the observer");
        observerList.remove(observer);
    }

}
