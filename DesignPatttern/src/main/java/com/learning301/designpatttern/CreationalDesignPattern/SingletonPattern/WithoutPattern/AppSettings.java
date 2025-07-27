package com.learning301.designpatttern.CreationalDesignPattern.SingletonPattern.WithoutPattern;

/**
 * AppSettings - WITHOUT Singleton Pattern
 * 
 * Problems with this approach:
 * 1. MULTIPLE INSTANCES - Can create many AppSettings objects
 * 2. MEMORY WASTE - Each instance consumes memory unnecessarily
 * 3. INCONSISTENT STATE - Different instances might have different values
 * 4. NO GLOBAL ACCESS - No standardized way to access settings
 * 5. INITIALIZATION OVERHEAD - Expensive initialization repeated
 */
public class AppSettings {
    private String apiKey;
    private String apiValue;

    /**
     * PUBLIC CONSTRUCTOR - PROBLEM!
     * 
     * Allows unlimited instance creation:
     * - new AppSettings() creates new instance every time
     * - No control over instance creation
     * - Memory waste with multiple identical objects
     * - Potential inconsistency if instances are modified differently
     */
    public AppSettings(){
        // Expensive initialization (simulated)
        System.out.println("Creating new AppSettings instance - expensive operation!");
        
        // In real applications, this might involve:
        // - Reading configuration files
        // - Database connections
        // - Network calls to configuration services
        // - Complex initialization logic
        apiKey = "2h345j3j3";
        apiValue = "aaajjjwnje";
    }

    /**
     * Get API Key
     * Each instance has its own copy of this data
     */
    public String getApiKey(){
        return apiKey;
    }

    /**
     * Get API Value
     * Each instance has its own copy of this data
     */
    public String getApiValue(){
        return apiValue;
    }
    
    /**
     * String representation showing instance hash
     * Demonstrates that multiple instances are different objects
     */
    @Override
    public String toString() {
        return "AppSettings{" +
                "apiKey='" + apiKey + '\'' +
                ", apiValue='" + apiValue + '\'' +
                ", instanceHash=" + this.hashCode() +
                '}';
    }
}
