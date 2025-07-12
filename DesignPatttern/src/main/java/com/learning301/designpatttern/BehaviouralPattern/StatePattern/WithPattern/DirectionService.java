package com.learning301.designpatttern.BehaviouralPattern.StatePattern.WithPattern;

/**
 * DirectionService - Context Class with STATE MANAGEMENT
 * 
 * CHANGE 18: Context now manages automatic state transitions
 * Provides trigger methods that cause states to change automatically
 */
public class DirectionService {

    // Current transportation state
    private TransportationMode currentState;

    /**
     * Constructor to initialize with a transportation state
     */
    public DirectionService(TransportationMode initialState){
        this.currentState = initialState;
        System.out.println("🎯 DirectionService initialized with: " + 
                          initialState.getClass().getSimpleName());
    }

    /**
     * CHANGE 19: Method for states to change themselves
     * This is called by states when they need to transition
     */
    public void changeState(TransportationMode newState) {
        System.out.println("🔄 STATE TRANSITION: " + 
                          currentState.getClass().getSimpleName() + 
                          " → " + newState.getClass().getSimpleName());
        this.currentState = newState;
    }

    /**
     * CHANGE 20: Get ETA - now passes context to state
     * State can trigger transitions during this call
     */
    public void getEta() {
        currentState.getEta(this); // Pass context to state
    }
    
    /**
     * CHANGE 21: Get directions - now passes context to state
     * State can trigger transitions during this call
     */
    public void getDirection() {
        currentState.getDirection(this); // Pass context to state
    }
    
    // CHANGE 22: NEW METHODS - Trigger automatic state transitions
    /**
     * Simulate traffic jam condition
     * This triggers automatic state transitions based on current state
     */
    public void encounterTrafficJam() {
        System.out.println("\n🚨 TRAFFIC JAM DETECTED!");
        currentState.handleTrafficJam(this); // State decides what to do
    }
    
    /**
     * Simulate weather change condition
     * This triggers automatic state transitions based on current state
     */
    public void weatherChanged() {
        System.out.println("\n🌧️ WEATHER CHANGED!");
        currentState.handleWeatherChange(this); // State decides what to do
    }
    
    /**
     * CHANGE 23: Get current state name for debugging
     */
    public String getCurrentState() {
        return currentState.getClass().getSimpleName();
    }
}