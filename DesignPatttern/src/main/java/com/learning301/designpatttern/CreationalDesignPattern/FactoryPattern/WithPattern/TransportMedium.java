package com.learning301.designpatttern.CreationalDesignPattern.FactoryPattern.WithPattern;

/**
 * TransportMedium Interface - Product Interface in Factory Pattern
 * 
 * Defines the contract that all concrete transport products must follow
 * This is the common interface returned by the factory
 * Allows client to work with different transport types uniformly
 */
public interface TransportMedium {
    /**
     * Start the transport medium
     * Each concrete implementation will have its own start behavior
     */
    public void start();
}
