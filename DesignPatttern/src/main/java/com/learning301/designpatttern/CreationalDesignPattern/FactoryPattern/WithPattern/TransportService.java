package com.learning301.designpatttern.CreationalDesignPattern.FactoryPattern.WithPattern;

/**
 * TransportService - Client using Factory Pattern
 * 
 * Demonstrates how client uses factory to create objects
 * Client doesn't need to know about concrete classes (Car, Bike, Bus)
 * Only knows about the factory and the common interface (TransportMedium)
 * 
 * Benefits demonstrated:
 * - Client code is decoupled from concrete classes
 * - Easy to add new transport types without changing client
 * - Centralized object creation logic
 */
public class TransportService {
    public static void main(String[] args) {
        System.out.println("=== Factory Pattern Demonstration ===");
        
        // Client uses factory instead of 'new Car()' or 'new Bike()'
        // Factory handles the object creation complexity
        TransportMedium car = TransportFactory.createMedium("car");
        TransportMedium bike = TransportFactory.createMedium("BiKE"); // Case insensitive
        TransportMedium bus = TransportFactory.createMedium("bus");

        System.out.println("\n--- Starting Different Transport Types ---");
        // Client works with common interface, not concrete classes
        car.start();  // Calls Car's implementation
        bike.start(); // Calls Bike's implementation
        bus.start();  // Calls Bus's implementation
        
        System.out.println("\n=== Factory Pattern Benefits ===");
        System.out.println("✅ Client doesn't use 'new' directly");
        System.out.println("✅ Factory encapsulates object creation");
        System.out.println("✅ Easy to add new transport types");
        System.out.println("✅ Client works with common interface");
    }
}
