package com.learning301.designpatttern.StructuralDesignPattern.FacadePattern.WithoutPattern;

/**
 * ClientService - WITHOUT Facade Pattern
 * 
 * Problems demonstrated:
 * 1. COMPLEX CLIENT CODE - Must manage multiple subsystem objects
 * 2. TIGHT COUPLING - Client directly depends on all subsystem classes
 * 3. COORDINATION BURDEN - Client must handle service interactions
 * 4. KNOWLEDGE REQUIREMENT - Client must understand all subsystems
 * 5. MAINTENANCE ISSUES - Changes to subsystems affect client code
 */
public class ClientService {
    public static void main(String[] args) {
        System.out.println("=== WITHOUT Facade Pattern ===");
        
        // PROBLEM 1: Client must create and manage multiple subsystem objects
        System.out.println("\n--- Client creating multiple subsystem objects ---");
        UserService userService = new UserService();
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService();
        
        System.out.println("Client created 3 separate service objects");

        // PROBLEM 2: Client must call each service individually
        System.out.println("\n--- Client making separate calls to each service ---");
        System.out.println("1. " + userService.getUserDetails());
        System.out.println("2. " + paymentService.getPaymentDetails());
        System.out.println("3. " + orderService.getOrderDetails());
        
        // PROBLEM 3: Client must handle coordination and aggregation
        System.out.println("\n--- Client manually aggregating results ---");
        String manualAggregation = "Manual Aggregation:\n" +
                                  userService.getUserDetails() + "\n" +
                                  orderService.getOrderDetails() + "\n" +
                                  paymentService.getPaymentDetails();
        System.out.println(manualAggregation);
        
        // PROBLEM 4: What if we need to add more services?
        System.out.println("\n--- Problems with this approach ---");
        System.out.println("❌ Client code is complex and cluttered");
        System.out.println("❌ Client tightly coupled to all subsystem classes");
        System.out.println("❌ Client must know about all service dependencies");
        System.out.println("❌ Adding new services requires client code changes");
        System.out.println("❌ No centralized coordination of services");
        System.out.println("❌ Client responsible for error handling across services");
        System.out.println("❌ Difficult to maintain and extend");
        
        System.out.println("\n--- Imagine if we had 10+ services! ---");
        System.out.println("Client would need to:");
        System.out.println("- Create 10+ service objects");
        System.out.println("- Make 10+ individual service calls");
        System.out.println("- Handle coordination between all services");
        System.out.println("- Manage dependencies and error handling");
        System.out.println("- Aggregate results from all services");
        System.out.println("This becomes unmanageable quickly!");
    }
}
