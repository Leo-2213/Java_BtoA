package com.learning301.designpatttern.BehaviouralPattern.StrategyPattern.WithPattern;

/**
 * PaymentMode - Strategy interface in the Strategy Pattern
 * 
 * This interface defines the contract for all payment strategy implementations.
 * It declares the algorithm that varies across different payment methods.
 * Each concrete strategy will implement this interface with its specific payment processing logic.
 */
public interface PaymentMode {
    /**
     * Process a payment with the specific payment method
     * 
     * @param amount The amount to be processed
     */
    public void processPayment(int amount);
}
