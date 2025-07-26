package com.learning301.designpatttern.CreationalDesignPattern.FactoryPattern.WithoutPattern;

/**
 * TransportService - WITHOUT Factory Pattern
 * 
 * Problems with this approach:
 * 1. TIGHT COUPLING - Client directly depends on concrete classes
 * 2. HARD TO EXTEND - Adding new transport types requires client changes
 * 3. NO ENCAPSULATION - Object creation logic scattered in client code
 * 4. VIOLATES DIP - Client depends on concrete classes, not abstractions
 */
public class TransportService {
    public static void main(String[] args) {
        System.out.println("=== WITHOUT Factory Pattern ===");
        
        // PROBLEM: Client directly uses 'new' with concrete classes
        // Client must know about Car and Bike classes
        TransportMedium car = new Car();   // Direct instantiation
        TransportMedium bike = new Bike(); // Direct instantiation

        System.out.println("\n--- Starting Transport Types ---");
        car.start();
        bike.start();
        
        System.out.println("\n=== Problems with this approach ===");
        System.out.println("❌ Client tightly coupled to concrete classes");
        System.out.println("❌ Must modify client to add new transport types");
        System.out.println("❌ No centralized creation logic");
        System.out.println("❌ Violates Dependency Inversion Principle");
        System.out.println("❌ Hard to maintain and extend");
    }
}
