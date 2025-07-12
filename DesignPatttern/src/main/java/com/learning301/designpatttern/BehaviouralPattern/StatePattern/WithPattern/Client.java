package com.learning301.designpatttern.BehaviouralPattern.StatePattern.WithPattern;

/**
 * Client - Demonstrates TRUE STATE PATTERN with Automatic Transitions
 * 
 * CHANGE 24: Client no longer manually sets states
 * Instead, client triggers conditions that cause automatic state transitions
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("=== TRUE STATE PATTERN DEMONSTRATION ===");
        
        // CHANGE 25: Start with Car state
        DirectionService service = new DirectionService(new Car());
        
        System.out.println("\n--- Initial State: Car ---");
        service.getDirection();
        service.getEta();
        System.out.println("Current state: " + service.getCurrentState());
        
        // CHANGE 26: Trigger automatic state transition
        // Car will automatically switch to Bike due to traffic
        service.encounterTrafficJam();
        
        System.out.println("\n--- After Traffic Jam (Auto-switched to Bike) ---");
        service.getDirection();
        service.getEta();
        System.out.println("Current state: " + service.getCurrentState());
        
        // CHANGE 27: Trigger another automatic state transition
        // Bike will automatically switch to Walking due to weather
        service.weatherChanged();
        
        System.out.println("\n--- After Weather Change (Auto-switched to Walking) ---");
        service.getDirection();
        service.getEta();
        System.out.println("Current state: " + service.getCurrentState());
        
        // CHANGE 28: Trigger state transition back to Car
        // Walking will switch back to Car when traffic clears
        service.encounterTrafficJam(); // Traffic cleared
        
        System.out.println("\n--- After Traffic Cleared (Auto-switched back to Car) ---");
        service.getDirection();
        service.getEta();
        System.out.println("Current state: " + service.getCurrentState());

    }
}