package com.learning301.designpatttern.CreationalDesignPattern.FactoryPattern.WithPattern;

/**
 * TransportFactory - Factory Class (Core of Factory Pattern)
 * 
 * Encapsulates object creation logic for different transport types
 * Client doesn't need to know about concrete classes
 * Provides centralized creation logic that's easy to maintain and extend
 * 
 * Benefits:
 * - Hides complex object creation from client
 * - Easy to add new transport types without changing client code
 * - Centralized creation logic
 * - Follows Open/Closed Principle
 */
public class TransportFactory {

    /**
     * Factory Method - Creates transport objects based on type
     * 
     * This is the core factory method that encapsulates object creation
     * Client calls this method instead of using 'new' directly
     * 
     * @param medium the type of transport to create ("car", "bike", "bus")
     * @return TransportMedium instance of the requested type
     * @throws IllegalArgumentException if transport type is not supported
     */
    public static TransportMedium createMedium(String medium){
        switch (medium.toLowerCase()){
            case "car":
                return new Car(); // Factory creates Car instance
            case "bike":
                return new Bike(); // Factory creates Bike instance
            case "bus":
                return new Bus(); // Factory creates Bus instance
            default:
                throw new IllegalArgumentException("Unsupported Transport type: " + medium);
        }
    }
}
