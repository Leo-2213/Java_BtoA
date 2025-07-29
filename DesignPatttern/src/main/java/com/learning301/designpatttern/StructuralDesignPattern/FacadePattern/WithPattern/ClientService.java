package com.learning301.designpatttern.StructuralDesignPattern.FacadePattern.WithPattern;

/**
 * ClientService - Client using Facade Pattern
 * 
 * Demonstrates how Facade Pattern simplifies client code
 * Client only needs to know about the Facade (ApiGateway)
 * No need to understand or interact with complex subsystems
 * 
 * Benefits for client:
 * - Simple, clean code
 * - Single point of interaction
 * - No knowledge of subsystem complexity required
 * - Reduced coupling to subsystem classes
 * - Easy to use and maintain
 */
public class ClientService {
    public static void main(String[] args) {
        System.out.println("=== Facade Pattern Demonstration ===");
        
        // FACADE PATTERN: Client only interacts with the Facade
        // No need to create or manage individual subsystem objects
        ApiGateway apiGateway = new ApiGateway();

        System.out.println("\n--- Client making single facade call ---");
        
        // SIMPLE CLIENT CODE: One method call gets complete functionality
        // Behind the scenes, Facade coordinates UserService, OrderService, PaymentService
        // Client doesn't need to know about this complexity
        String fullDetails = apiGateway.getFullOrderDetails("Abhijeet", "10202", "Paytm");

        System.out.println("\n--- Complete Result from Facade ---");
        System.out.println(fullDetails);
        
        System.out.println("\n--- Demonstrating Additional Facade Methods ---");
        
        // Example: Using another facade method
        String basicInfo = apiGateway.getBasicOrderInfo("Abhijeet", "10202");
        System.out.println("\nBasic Info Result:");
        System.out.println(basicInfo);
        
        // Example: Using validation facade method
        boolean isValid = apiGateway.validateOrder("Abhijeet", "10202", "Paytm");
        System.out.println("\nOrder Validation Result: " + isValid);
        
        System.out.println("\n=== Facade Pattern Benefits Demonstrated ===");
        System.out.println("✅ Simple client code - only one object to interact with");
        System.out.println("✅ Single method call replaces multiple subsystem calls");
        System.out.println("✅ Client doesn't need to know about UserService, OrderService, PaymentService");
        System.out.println("✅ Facade handles all subsystem coordination and complexity");
        System.out.println("✅ Easy to add new functionality without changing client code");
        System.out.println("✅ Reduced coupling between client and subsystem classes");
        
        System.out.println("\n--- What client DOESN'T need to do (thanks to Facade) ---");
        System.out.println("❌ Create UserService, OrderService, PaymentService instances");
        System.out.println("❌ Call each service individually");
        System.out.println("❌ Handle coordination between services");
        System.out.println("❌ Aggregate results from multiple services");
        System.out.println("❌ Manage dependencies between subsystems");
        System.out.println("❌ Know about subsystem implementation details");
    }
}
