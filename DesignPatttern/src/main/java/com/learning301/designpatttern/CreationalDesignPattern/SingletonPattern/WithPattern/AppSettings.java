package com.learning301.designpatttern.CreationalDesignPattern.SingletonPattern.WithPattern;

/**
 * AppSettings - Singleton Pattern Implementation
 * 
 * Ensures only one instance of application settings exists
 * Provides global access point to configuration data
 * 
 * Singleton Pattern Components:
 * 1. Private static instance variable
 * 2. Private constructor (prevents direct instantiation)
 * 3. Public static getInstance() method (global access point)
 * 4. Lazy initialization (creates instance when first needed)
 * 
 * Benefits:
 * - Single source of truth for application settings
 * - Global access without global variables
 * - Lazy initialization saves memory
 * - Controlled instantiation
 */
public class AppSettings {

    // Static instance variable - holds the single instance
    // Made private for better encapsulation
    private static AppSettings instance;

    // Application configuration data
    private final String apiKey;    // Made final for immutability
    private final String apiValue;  // Made final for immutability

    /**
     * Private Constructor - Core of Singleton Pattern
     * 
     * Prevents direct instantiation using 'new AppSettings()'
     * Only getInstance() method can create the instance
     * Initializes configuration data
     */
    private AppSettings(){
        // Initialize configuration values
        // In real application, these might come from:
        // - Configuration files
        // - Environment variables
        // - Database
        // - External services
        this.apiKey = "2h345j3j3";
        this.apiValue = "aaajjjwnje";
        
        System.out.println("AppSettings instance created!"); // For demonstration
    }

    /**
     * getInstance() - Global Access Point (Core Singleton Method)
     * 
     * Provides the single instance of AppSettings
     * Uses lazy initialization - creates instance only when first needed
     * 
     * Note: This implementation is NOT thread-safe
     * For thread safety, use synchronized or other techniques
     * 
     * @return the single AppSettings instance
     */
    public static synchronized AppSettings getInstance(){
        // Lazy initialization - create instance only when needed
        if(instance == null){
            instance = new AppSettings();
        }
        return instance;
    }

    /**
     * Thread-Safe Alternative (commented out)
     * 
     * Uncomment this and comment above method for thread safety:
     * 
     * public static synchronized AppSettings getInstance(){
     *     if(instance == null){
     *         instance = new AppSettings();
     *     }
     *     return instance;
     * }
     */

    /**
     * Get API Key configuration
     * @return the API key
     */
    public String getApiKey(){
        return apiKey;
    }

    /**
     * Get API Value configuration
     * @return the API value
     */
    public String getApiValue(){
        return apiValue;
    }
    
    /**
     * Get instance information for debugging
     * @return string representation with instance hash
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
