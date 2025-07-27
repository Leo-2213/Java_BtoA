package com.learning301.designpatttern.CreationalDesignPattern.BuilderPattern.WithPattern;

/**
 * WithBuilderPattern - Client demonstrating Builder Pattern
 * 
 * Shows how Builder Pattern provides:
 * - Fluent interface for object construction
 * - Clear, readable code
 * - Flexible parameter setting
 * - Step-by-step object building
 */
public class WithBuilderPattern {
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern Demonstration ===");
        
        // Builder Pattern: Fluent interface with method chaining
        // Required parameters in constructor, optional via fluent methods
        House luxuryHouse = new House.HouseBuilder("Luxury Villa", true) // Required params
                            .setGarage(true)        // Optional: Add garage
                            .setGarden(true)        // Optional: Add garden
                            .setSwimmingPool(true)  // Optional: Add swimming pool
                            .build();               // Create final product

        System.out.println("\n--- Luxury House ---");
        System.out.println(luxuryHouse);
        
        // Another example: Basic house with minimal features
        House basicHouse = new House.HouseBuilder("Apartment", true) // Required params
                           .setGarage(false)       // Optional: No garage
                           .setSwimmingPool(false) // Optional: No pool
                           .build();               // Garden not set (will be null)
        
        System.out.println("\n--- Basic House ---");
        System.out.println(basicHouse);
        
        // Example: Custom house with selective features
        House customHouse = new House.HouseBuilder("Townhouse", true)
                            .setGarden(true)        // Only garden, no garage/pool
                            .build();
        
        System.out.println("\n--- Custom House ---");
        System.out.println(customHouse);
        
        System.out.println("\n=== Builder Pattern Benefits ===");
        System.out.println("✅ Fluent interface - readable method chaining");
        System.out.println("✅ Flexible construction - set only needed parameters");
        System.out.println("✅ Immutable product - no setters after construction");
        System.out.println("✅ No telescoping constructors - avoids parameter confusion");
        System.out.println("✅ Step-by-step building - clear construction process");
    }
}
