package com.learning301.designpatttern.CreationalDesignPattern.SingletonPattern.WithPattern;

/**
 * App - Client demonstrating Singleton Pattern
 * 
 * Shows how Singleton Pattern ensures:
 * - Only one instance exists
 * - Global access to the same instance
 * - Same object reference returned every time
 * - Shared state across the application
 */
public class App {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Demonstration ===");
        
        // Get first instance - this will create the singleton
        System.out.println("\n--- Getting First Instance ---");
        AppSettings appSettings1 = AppSettings.getInstance();
        
        // Get second instance - should return the SAME instance
        System.out.println("\n--- Getting Second Instance ---");
        AppSettings appSettings2 = AppSettings.getInstance();
        
        // Get third instance - should return the SAME instance
        System.out.println("\n--- Getting Third Instance ---");
        AppSettings appSettings3 = AppSettings.getInstance();

        System.out.println("\n--- Accessing Configuration Data ---");
        System.out.println("API Key: " + appSettings1.getApiKey());
        System.out.println("API Value: " + appSettings1.getApiValue());

        System.out.println("\n--- Verifying Singleton Behavior ---");
        
        // Test 1: Reference equality (same object)
        System.out.println("appSettings1 == appSettings2: " + (appSettings1 == appSettings2));
        System.out.println("appSettings1 == appSettings3: " + (appSettings1 == appSettings3));
        System.out.println("appSettings2 == appSettings3: " + (appSettings2 == appSettings3));
        
        // Test 2: Object equality (should also be true for same instance)
        System.out.println("appSettings1.equals(appSettings2): " + appSettings1.equals(appSettings2));
        
        // Test 3: Hash codes (should be identical for same instance)
        System.out.println("appSettings1.hashCode(): " + appSettings1.hashCode());
        System.out.println("appSettings2.hashCode(): " + appSettings2.hashCode());
        System.out.println("appSettings3.hashCode(): " + appSettings3.hashCode());
        
        // Test 4: toString() showing instance information
        System.out.println("\n--- Instance Information ---");
        System.out.println("Instance 1: " + appSettings1.toString());
        System.out.println("Instance 2: " + appSettings2.toString());
        System.out.println("Instance 3: " + appSettings3.toString());
        
        System.out.println("\n=== Singleton Pattern Benefits Demonstrated ===");
        System.out.println("✅ Only one instance created (check console output)");
        System.out.println("✅ Global access point via getInstance()");
        System.out.println("✅ Same object reference returned every time");
        System.out.println("✅ Shared configuration across application");
        System.out.println("✅ Lazy initialization - created when first needed");
        
        // Demonstrate that we cannot create instances directly
        System.out.println("\n--- Cannot Create Direct Instances ---");
        System.out.println("new AppSettings() is not allowed - constructor is private!");
        // AppSettings directInstance = new AppSettings(); // This would cause compilation error
    }
}
