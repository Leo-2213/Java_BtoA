package com.learning301.designpatttern.BehaviouralPattern.StatePattern.WithPattern;

/**
 * Bike - Concrete State Implementation with AUTOMATIC TRANSITIONS
 * 
 * CHANGE 8: Bike state also implements automatic transitions
 */
public class Bike implements TransportationMode{
    
    /**
     * Bike-specific direction calculation
     * CHANGE 9: Now receives context parameter
     */
    @Override
    public void getDirection(DirectionService context) {
        System.out.println("Getting Direction for Bike: Using bike lanes and paths");
    }

    /**
     * Bike-specific ETA calculation
     * CHANGE 10: Now receives context parameter
     */
    @Override
    public void getEta(DirectionService context) {
        System.out.println("Getting ETA for Bike: 45 minutes via bike paths");
    }
    
    /**
     * CHANGE 11: NEW METHOD - Bike handles traffic jam differently
     * Bike is already good for traffic, so no state change needed
     */
    @Override
    public void handleTrafficJam(DirectionService context) {
        System.out.println("🚴 Bike: Traffic jam detected, but bikes can navigate through!");
        System.out.println("🚴 Staying in Bike mode - no state change needed");
        // No state transition - bike is already optimal for traffic
    }
    
    /**
     * CHANGE 12: NEW METHOD - Bike switches to Walking in bad weather
     * Biking in rain/snow is dangerous, so switch to walking
     */
    @Override
    public void handleWeatherChange(DirectionService context) {
        System.out.println("🚴 Bike detected bad weather (rain/snow)!");
        System.out.println("🚴 Automatically switching to Walking for safety...");
        context.changeState(new Walking()); // AUTOMATIC TRANSITION
    }
}