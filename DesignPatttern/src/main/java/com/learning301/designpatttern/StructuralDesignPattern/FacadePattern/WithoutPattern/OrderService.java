package com.learning301.designpatttern.StructuralDesignPattern.FacadePattern.WithoutPattern;

/**
 * OrderService - WITHOUT Facade Pattern
 * 
 * Problems:
 * - Client must directly create and manage this service
 * - No coordination with UserService or PaymentService
 * - Client must know about this service's interface
 * - Adding complexity here affects client code directly
 */
public class OrderService {
    
    /**
     * Get order details - client must call this directly
     * No parameters because there's no coordination layer
     */
    public String getOrderDetails(){
        System.out.println("OrderService called directly by client");
        return "Order service is called";
    }
}
