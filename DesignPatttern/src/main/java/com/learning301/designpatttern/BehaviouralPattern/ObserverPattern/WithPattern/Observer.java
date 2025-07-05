package com.learning301.designpatttern.BehaviouralPattern.ObserverPattern.WithPattern;

/**
 * Observer interface - Defines the contract for objects that need to be notified of changes
 * This is a key component of the Observer pattern that receives updates from subjects
 * they are registered with.
 */
public interface Observer {

    /**
     * Called by the subject when its state changes
     * Observers implement this method to define how they respond to updates
     * 
     * @param temp The updated temperature value from the subject
     */
    public void updateTemp(float temp);

}
