package com.learning301.designpatttern.BehaviouralPattern.StatePattern.WithPattern;

/**
 * TransportationMode Interface - TRUE State Interface
 * 
 * CHANGE 1: Added context parameter to methods
 * This allows states to trigger automatic transitions
 * States can now change to other states based on conditions
 */
public interface TransportationMode {
    /**
     * Get directions based on current transportation mode
     * @param context - DirectionService context for state transitions
     */
    void getDirection(DirectionService context);
    
    /**
     * Get estimated time of arrival based on current transportation mode
     * @param context - DirectionService context for state transitions
     */
    void getEta(DirectionService context);
    
    // CHANGE 2: Added methods that trigger automatic state transitions
    /**
     * Handle traffic jam condition - may trigger state change
     * @param context - DirectionService context for state transitions
     */
    void handleTrafficJam(DirectionService context);
    
    /**
     * Handle weather change condition - may trigger state change
     * @param context - DirectionService context for state transitions
     */
    void handleWeatherChange(DirectionService context);
}