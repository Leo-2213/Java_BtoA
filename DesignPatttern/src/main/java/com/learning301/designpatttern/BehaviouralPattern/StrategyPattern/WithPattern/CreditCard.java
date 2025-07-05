package com.learning301.designpatttern.BehaviouralPattern.StrategyPattern.WithPattern;

/**
 * CreditCard - Concrete Strategy in the Strategy Pattern
 * 
 * This class implements the PaymentMode interface with specific logic
 * for processing credit card payments. It represents one of the algorithms
 * that can be selected and used at runtime.
 */
public class CreditCard implements PaymentMode{

    /**
     * Implementation of the payment processing algorithm for credit cards
     * 
     * @param amount The amount to be processed via credit card
     */
    @Override
    public void processPayment(int amount) {
        System.out.println("Processing credit card payment of amount "+amount);
        // In a real implementation, this would include credit card-specific logic
        // such as validation, authorization, charging, etc.
    }

}
