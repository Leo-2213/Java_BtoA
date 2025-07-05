package com.learning301.designpatttern.BehaviouralPattern.ObserverPattern.WithPattern;

/**
 * Subject interface - Defines the contract for objects that can be observed
 * This is a key component of the Observer pattern that maintains a list of observers
 * and provides methods to register, remove, and notify them of state changes.
 */
public interface Subject {
    /**
     * Registers a new observer to receive updates
     * @param observer The observer to be registered
     */
    public void registerObserver(Observer observer);
    
    /**
     * Removes an observer so it no longer receives updates
     * @param observer The observer to be removed
     */
    public void removeObserver(Observer observer);
    
    /**
     * Notifies all registered observers about state changes
     * This is typically called when the subject's state changes
     */
    public void notifyObservers();
}
