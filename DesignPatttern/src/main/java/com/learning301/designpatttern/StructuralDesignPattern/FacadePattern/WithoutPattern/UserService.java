package com.learning301.designpatttern.StructuralDesignPattern.FacadePattern.WithoutPattern;

/**
 * UserService - WITHOUT Facade Pattern
 * 
 * Problems:
 * - Client must directly interact with this service
 * - Client must know about this service's existence and methods
 * - No coordination with other services
 * - Client responsible for managing this service's lifecycle
 */
public class UserService {
    
    /**
     * Get user details - client must call this directly
     * No parameters because client doesn't coordinate with other services
     */
    public String getUserDetails(){
        System.out.println("UserService called directly by client");
        return "User Service is called";
    }
}
