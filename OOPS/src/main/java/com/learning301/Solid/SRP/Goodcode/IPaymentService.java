package com.learning301.Solid.SRP.Goodcode;

/**
 * Interface for payment processing services.
 * This interface follows the Single Responsibility Principle by focusing only on payment operations.
 */
public interface IPaymentService {
    /**
     * Processes a payment for the specified amount
     * 
     * @param amount The payment amount to process
     */
    void makePayment(int amount);
}