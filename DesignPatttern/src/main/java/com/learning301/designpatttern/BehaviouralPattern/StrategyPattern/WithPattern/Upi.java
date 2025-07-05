package com.learning301.designpatttern.BehaviouralPattern.StrategyPattern.WithPattern;

/**
 * Upi - Concrete Strategy in the Strategy Pattern
 * 
 * This class implements the PaymentMode interface with specific logic
 * for processing UPI (Unified Payment Interface) payments. It represents 
 * one of the algorithms that can be selected and used at runtime.
 */
public class Upi implements PaymentMode{

    /**
     * Implementation of the payment processing algorithm for UPI payments
     * 
     * @param amount The amount to be processed via UPI
     */
    @Override
    public void processPayment(int amount) {
        System.out.println("Processing UPI payment of amount "+amount);
        // In a real implementation, this would include UPI-specific logic
        // such as generating UPI intent, verifying UPI ID, etc.
    }

}
