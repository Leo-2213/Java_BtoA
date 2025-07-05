package com.learning301.designpatttern.BehaviouralPattern.StrategyPattern.WithPattern;

/**
 * DebitCard - Concrete Strategy in the Strategy Pattern
 * 
 * This class implements the PaymentMode interface with specific logic
 * for processing debit card payments. It represents one of the algorithms
 * that can be selected and used at runtime.
 */
public class DebitCard implements PaymentMode{

    /**
     * Implementation of the payment processing algorithm for debit cards
     * 
     * @param amount The amount to be processed via debit card
     */
    @Override
    public void processPayment(int amount) {
        System.out.println("Processing debit card payment of amount "+amount);
        // In a real implementation, this would include debit card-specific logic
        // such as checking available balance, PIN verification, etc.
    }

}
