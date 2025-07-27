package com.learning301.designpatttern.CreationalDesignPattern.SingletonPattern.WithoutPattern;

/**
 * App - WITHOUT Singleton Pattern
 * 
 * Problems demonstrated:
 * 1. MULTIPLE INSTANCES - Creates separate objects unnecessarily
 * 2. MEMORY WASTE - Each instance consumes memory
 * 3. PERFORMANCE OVERHEAD - Repeated expensive initialization
 * 4. INCONSISTENCY RISK - Different instances could have different state
 * 5. NO GLOBAL ACCESS CONTROL - Anyone can create instances anywhere
 */
public class App {
    public static void main(String[] args) {
        System.out.println("=== WITHOUT Singleton Pattern ===");
        
        // PROBLEM: Creating multiple instances
        System.out.println("\n--- Creating Multiple Instances ---");
        AppSettings appSettings1 = new AppSettings();  // Creates instance 1
        AppSettings appSettings2 = new AppSettings();  // Creates instance 2
        AppSettings appSettings3 = new AppSettings();  // Creates instance 3
        
        // Each creation triggers expensive initialization!
        
        System.out.println("\n--- Accessing Configuration Data ---");
        System.out.println("API Key from instance 1: " + appSettings1.getApiKey());
        System.out.println("API Value from instance 1: " + appSettings1.getApiValue());

        System.out.println("\n--- Demonstrating Problems ---");
        
        // Problem 1: Different object references
        System.out.println("appSettings1 == appSettings2: " + (appSettings1 == appSettings2));
        System.out.println("appSettings1 == appSettings3: " + (appSettings1 == appSettings3));
        
        // Problem 2: Objects are not equal (different instances)
        System.out.println("appSettings1.equals(appSettings2): " + appSettings1.equals(appSettings2));
        
        // Problem 3: Different hash codes (different objects)
        System.out.println("appSettings1.hashCode(): " + appSettings1.hashCode());
        System.out.println("appSettings2.hashCode(): " + appSettings2.hashCode());
        System.out.println("appSettings3.hashCode(): " + appSettings3.hashCode());
        
        // Problem 4: Memory waste - multiple identical objects
        System.out.println("\n--- Instance Information (showing memory waste) ---");
        System.out.println("Instance 1: " + appSettings1.toString());
        System.out.println("Instance 2: " + appSettings2.toString());
        System.out.println("Instance 3: " + appSettings3.toString());
        
        // Problem 5: Can create unlimited instances
        System.out.println("\n--- Can Create Unlimited Instances ---");
        for (int i = 1; i <= 5; i++) {
            AppSettings wastefulInstance = new AppSettings();
            System.out.println("Wasteful instance " + i + ": " + wastefulInstance.hashCode());
        }
        
        System.out.println("\n=== Problems with this approach ===");
        System.out.println("❌ Multiple instances created unnecessarily");
        System.out.println("❌ Memory waste - each instance stores same data");
        System.out.println("❌ Performance overhead - repeated initialization");
        System.out.println("❌ No control over instance creation");
        System.out.println("❌ Risk of inconsistent state across instances");
        System.out.println("❌ No global access point for configuration");
    }
}
