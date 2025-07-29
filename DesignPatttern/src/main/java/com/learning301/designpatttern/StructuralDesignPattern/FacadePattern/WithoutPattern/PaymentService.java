package com.learning301.designpatttern.StructuralDesignPattern.FacadePattern.WithoutPattern;

/**
 * PaymentService - WITHOUT Facade Pattern
 * 
 * Problems:
 * - Client must directly instantiate and use this service
 * - No integration with UserService or OrderService
 * - Client must understand payment service complexity
 * - Changes to this service directly impact client code
 */
public class PaymentService {
    
    /**
     * Get payment details - client must call this directly
     * No coordination with other services
     */
    public String getPaymentDetails(){
        System.out.println("PaymentService called directly by client");
        return "Payment Service is called";
    }
}
