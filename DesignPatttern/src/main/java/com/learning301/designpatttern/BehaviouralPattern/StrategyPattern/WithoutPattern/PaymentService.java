package com.learning301.designpatttern.BehaviouralPattern.StrategyPattern.WithoutPattern;

/**
 * PaymentService - A class that processes payments without using the Strategy Pattern
 * 
 * This class demonstrates the problems that arise when not using the Strategy Pattern:
 * 1. Uses conditional statements to determine behavior
 * 2. Violates the Open/Closed Principle (must modify this class to add new payment types)
 * 3. Tightly couples the payment processing logic with the payment service
 * 4. Has a potential bug with string comparison (using == instead of equals())
 */
public class PaymentService {

    // Unused instance variables
    private int amount;
    private String paymentType;

    /**
     * Process a payment based on the payment type string
     * 
     * This method uses conditional logic to determine which payment processing
     * to use, which violates the Open/Closed Principle and makes the code less maintainable.
     * 
     * @param amount The amount to be processed
     * @param paymentType A string identifier for the payment type
     */
    void processPayment(int amount, String paymentType){
        // NOTE: There's a bug here - string comparison should use equals() not ==
        // This demonstrates another problem with this approach
        if(paymentType.equals("CC")){
            System.out.println("Processing payment with credit card");
        }else if(paymentType.equals("DC")){
            System.out.println("Processing payment with debit card");
        }else if(paymentType.equals("UPI")){
            System.out.println("Processing payment with UPI");
        }else{
            System.out.println("Invalid payment type");
        }
        
        // To add a new payment method, we would need to modify this method
        // by adding another conditional branch, violating the Open/Closed Principle
    }
}
