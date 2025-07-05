package com.learning301.designpatttern.BehaviouralPattern.StrategyPattern.WithPattern;

/**
 * PaymentService - Context class in the Strategy Pattern
 * 
 * This class maintains a reference to a strategy object and delegates
 * the payment processing to the strategy object. It acts as the client-facing
 * interface that uses different payment strategies without being tightly coupled
 * to their specific implementations.
 */
public class PaymentService {

    // Reference to the current payment strategy
    PaymentMode paymentMode;

    /**
     * Process a payment using the provided payment strategy
     * 
     * This method demonstrates the key benefit of the Strategy Pattern:
     * the ability to switch algorithms (payment methods) at runtime
     * 
     * @param amount The amount to be processed
     * @param paymentMode The payment strategy to use for this transaction
     */
    public void makePayment(int amount, PaymentMode paymentMode){
        paymentMode.processPayment(amount);
    }

}
