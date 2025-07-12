package com.learning301.designpatttern.BehaviouralPattern.StatePattern.WithPattern;

/**
 * Walking - Concrete State Implementation with AUTOMATIC TRANSITIONS
 * 
 * CHANGE 13: Walking state also implements automatic transitions
 */
public class Walking implements TransportationMode{
    
    /**
     * Walking-specific direction calculation
     * CHANGE 14: Now receives context parameter
     */
    @Override
    public void getDirection(DirectionService context) {
        System.out.println("Getting Direction for Walking: Using sidewalks and pedestrian paths");
    }

    /**
     * Walking-specific ETA calculation
     * CHANGE 15: Now receives context parameter
     */
    @Override
    public void getEta(DirectionService context) {
        System.out.println("Getting ETA for Walking: 90 minutes on foot");
    }
    
    /**
     * CHANGE 16: NEW METHOD - Walking switches to Car when traffic clears
     * When traffic jam is over, walking can switch back to faster car
     */
    @Override
    public void handleTrafficJam(DirectionService context) {
        System.out.println("🚶 Walking: Traffic jam cleared!");
        System.out.println("🚶 Automatically switching back to Car for faster travel...");
        context.changeState(new Car()); // AUTOMATIC TRANSITION
    }
    
    /**
     * CHANGE 17: NEW METHOD - Walking is weather-resistant
     * Walking works in all weather conditions, so no state change
     */
    @Override
    public void handleWeatherChange(DirectionService context) {
        System.out.println("🚶 Walking: Weather change detected, but walking works in all weather!");
        System.out.println("🚶 Staying in Walking mode - no state change needed");
        // No state transition - walking works in all weather
    }
}