package com.learning301.designpatttern.BehaviouralPattern.IteratorPattern.WithPattern;

/**
 * Iterator Interface - Core of Iterator Pattern
 * 
 * Defines the contract for traversing elements in a collection
 * Provides uniform way to access elements without exposing internal structure
 * Generic interface allows iteration over any type of objects
 * 
 * Key benefits:
 * - Encapsulates traversal logic
 * - Provides uniform interface for different collection types
 * - Supports multiple simultaneous iterations
 * - Decouples client from collection implementation
 */
public interface Iterator<T> {
    
    /**
     * Check if there are more elements to iterate
     * @return true if more elements exist, false otherwise
     */
    public boolean hasNext();
    
    /**
     * Get the next element in the iteration
     * @return the next element of type T
     * @throws RuntimeException if no more elements (in real implementation)
     */
    public T next();
}
