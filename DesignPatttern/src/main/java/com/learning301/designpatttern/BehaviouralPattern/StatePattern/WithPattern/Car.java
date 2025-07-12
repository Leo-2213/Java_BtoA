package com.learning301.designpatttern.BehaviouralPattern.StatePattern.WithPattern;

/**
 * Car - Concrete State Implementation with AUTOMATIC TRANSITIONS
 * 
 * CHANGE 3: States now trigger their own transitions based on conditions
 * This is the key difference from Strategy Pattern
 */
public class Car implements TransportationMode{
    
    /**
     * Car-specific direction calculation
     * CHANGE 4: Now receives context parameter
     */
    @Override
    public void getDirection(DirectionService context) {
        System.out.println("Getting Direction for Car: Using highways and roads");
    }

    /**
     * Car-specific ETA calculation
     * CHANGE 5: Now receives context parameter
     */
    @Override
    public void getEta(DirectionService context) {
        System.out.println("Getting ETA for Car: 30 minutes via roads");
    }
    
    /**
     * CHANGE 6: NEW METHOD - Automatic state transition on traffic jam
     * Car automatically switches to Bike when traffic is heavy
     */
    @Override
    public void handleTrafficJam(DirectionService context) {
        System.out.println("🚗 Car detected heavy traffic!");
        System.out.println("🚗 Automatically switching to Bike to avoid traffic...");
        context.changeState(new Bike()); // AUTOMATIC TRANSITION
    }
    
    /**
     * CHANGE 7: NEW METHOD - Automatic state transition on weather change
     * Car switches to Walking when weather is bad for driving
     */
    @Override
    public void handleWeatherChange(DirectionService context) {
        System.out.println("🚗 Car detected heavy rain/snow!");
        System.out.println("🚗 Automatically switching to Walking for safety...");
        context.changeState(new Walking()); // AUTOMATIC TRANSITION
    }
}