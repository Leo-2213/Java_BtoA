package com.learning301.Solid.SRP.Goodcode;

/**
 * Implementation of payment service that handles payment processing.
 * This class follows the Single Responsibility Principle by focusing only on payment operations.
 */
public class Payment implements IPaymentService {

    /** Default payment amount to use when no specific amount is provided */
    private int defaultAmount;

    /**
     * Creates a new payment processor with the specified default amount
     * 
     * @param defaultAmount The default amount to use when no specific amount is provided
     */
    public Payment(int defaultAmount){
        this.defaultAmount = defaultAmount;
    }

    /**
     * Processes a payment for the specified amount
     * 
     * @param amount The payment amount to process (uses default amount if 0)
     */
    @Override
    public void makePayment(int amount){
        // Use the provided amount or default if 0
        int paymentAmount = (amount > 0) ? amount : defaultAmount;
        System.out.println("Payment processed successfully for amount: " + paymentAmount);
    }
}
