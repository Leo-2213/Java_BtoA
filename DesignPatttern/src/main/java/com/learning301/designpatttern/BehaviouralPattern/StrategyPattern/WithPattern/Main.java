package com.learning301.designpatttern.BehaviouralPattern.StrategyPattern.WithPattern;

/**
 * Main - Client class that demonstrates the Strategy Pattern
 * 
 * This class shows how different payment strategies can be used interchangeably
 * with the PaymentService context. It demonstrates the key benefit of the Strategy Pattern:
 * the ability to select and switch algorithms at runtime.
 */
public class Main {
    public static void main(String[] args) {
        // Create the context object
        PaymentService paymentService = new PaymentService();

        // Use the context with different strategies
        
        // Process payment using Credit Card strategy
        paymentService.makePayment(100, new CreditCard());

        // Process payment using UPI strategy
        paymentService.makePayment(300, new Upi());

        // Process payment using Debit Card strategy
        paymentService.makePayment(200, new DebitCard());
        
        // Note how we can easily switch between different payment strategies
        // without changing the PaymentService implementation
    }
}
