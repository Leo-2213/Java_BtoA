package com.learning301.designpatttern.CreationalDesignPattern.PrototypePattern.WithPattern;

/**
 * ProtoType Interface - Prototype Pattern Core
 * 
 * Defines the contract for cloneable objects
 * Generic interface allows type-safe cloning
 * All concrete prototypes must implement this interface
 * 
 * Key benefits:
 * - Standardizes cloning behavior across all prototypes
 * - Enables polymorphic cloning
 * - Type-safe return values
 * - Clear contract for prototype implementations
 */
public interface ProtoType<T>{
    /**
     * Create a copy of this object
     * 
     * Implementation should create a new instance with same state
     * For complex objects, should perform deep cloning
     * 
     * @return a new instance that is a copy of this object
     */
    T clone();
}
