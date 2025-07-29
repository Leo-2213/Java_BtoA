package com.learning301.designpatttern.StructuralDesignPattern.FacadePattern.WithPattern;

/**
 * ApiGateway - Facade Class
 * 
 * Core of the Facade Pattern - provides a unified, simplified interface
 * to a complex subsystem of services (User, Order, Payment)
 * 
 * Facade Pattern Benefits:
 * - Simplifies client interaction with complex subsystems
 * - Hides subsystem complexity from clients
 * - Provides a single entry point for related operations
 * - Reduces coupling between client and subsystem classes
 * - Centralizes subsystem coordination logic
 * 
 * Real-world analogy: Like a hotel concierge who handles
 * multiple services (restaurant, housekeeping, maintenance)
 * through a single point of contact
 */
public class ApiGateway {
    
    // References to subsystem components
    // Facade manages these complex subsystems internally
    private UserService userService;
    private OrderService orderService;
    private PaymentService paymentService;

    /**
     * Constructor - Initialize all subsystem components
     * 
     * Facade is responsible for creating and managing subsystem objects
     * Client doesn't need to know about these dependencies
     */
    public ApiGateway() {
        this.userService = new UserService();
        this.orderService = new OrderService();
        this.paymentService = new PaymentService();
        
        System.out.println("ApiGateway initialized with all subsystems");
    }

    /**
     * getFullOrderDetails - Facade Method (Simplified Interface)
     * 
     * This is the core facade method that:
     * 1. Coordinates multiple subsystem calls
     * 2. Aggregates results from different services
     * 3. Provides a single, simple interface to client
     * 4. Hides the complexity of individual service interactions
     * 
     * Without Facade, client would need to:
     * - Create UserService, OrderService, PaymentService instances
     * - Call each service individually
     * - Handle coordination and aggregation logic
     * - Manage dependencies between services
     * 
     * @param username user identifier for user service
     * @param orderID order identifier for order service
     * @param paymentMode payment method for payment service
     * @return aggregated details from all services
     */
    public String getFullOrderDetails(String username, String orderID, String paymentMode){
        System.out.println("\n--- Facade coordinating multiple subsystems ---");
        
        // Step 1: Get user details from UserService
        System.out.println("1. Calling UserService...");
        String userDetails = userService.getUserDetails(username);
        
        // Step 2: Get order details from OrderService
        System.out.println("2. Calling OrderService...");
        String orderDetails = orderService.getOrderDetails(orderID);
        
        // Step 3: Get payment details from PaymentService
        System.out.println("3. Calling PaymentService...");
        String paymentDetails = paymentService.getPaymentDetails(paymentMode);
        
        // Step 4: Aggregate and format results
        System.out.println("4. Aggregating results from all services...");
        String aggregatedResult = "=== COMPLETE ORDER DETAILS ===\n" +
                                userDetails + "\n" + 
                                orderDetails + "\n" + 
                                paymentDetails + "\n" +
                                "=== END OF DETAILS ===";
        
        return aggregatedResult;
    }
    
    /**
     * Additional facade methods could be added here
     * Each method would provide a simplified interface
     * to different combinations of subsystem operations
     */
    
    /**
     * Example: Get only user and order info (without payment)
     */
    public String getBasicOrderInfo(String username, String orderID) {
        String userDetails = userService.getUserDetails(username);
        String orderDetails = orderService.getOrderDetails(orderID);
        return "Basic Info:\n" + userDetails + "\n" + orderDetails;
    }
    
    /**
     * Example: Validate complete order (could add validation logic)
     */
    public boolean validateOrder(String username, String orderID, String paymentMode) {
        // Facade can add business logic that coordinates subsystems
        System.out.println("Validating order across all subsystems...");
        
        // In real implementation, this might:
        // - Validate user exists
        // - Check order status
        // - Verify payment method
        // - Ensure all data is consistent
        
        return true; // Simplified for demonstration
    }
}
