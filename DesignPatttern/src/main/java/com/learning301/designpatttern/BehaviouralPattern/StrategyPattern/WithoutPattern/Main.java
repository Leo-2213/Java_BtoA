package com.learning301.designpatttern.BehaviouralPattern.StrategyPattern.WithoutPattern;

/**
 * Main - Client class that demonstrates code without using the Strategy Pattern
 * 
 * This class shows how payment processing works without the Strategy Pattern.
 * It relies on string literals to identify payment types, which is less flexible
 * and more error-prone than using proper strategy objects.
 */
public class Main {
    public static void main(String[] args) {
        // Create the payment service
        PaymentService paymentService = new PaymentService();
        
        // Process payments using string identifiers
        // Note how this approach is more prone to errors (e.g., typos in strings)
        // and less flexible than using strategy objects
        
        paymentService.processPayment(100, "CC");  // Credit Card payment

        paymentService.processPayment(130, "DC");  // Debit Card payment

        paymentService.processPayment(150, "UPI"); // UPI payment
        
        // Adding a new payment method would require modifying the PaymentService class
    }
}
