package com.learning301.designpatttern.BehaviouralPattern.TemplateMethodPattern.WithPattern;

/**
 * Abstract Class - Parser (Template Method Pattern)
 * 
 * Defines the skeleton of the parsing algorithm in the template method parse()
 * Some steps are implemented here (open, close) - common behavior
 * Some steps are abstract (processData) - subclass-specific behavior
 * 
 * Template Method Pattern Components:
 * - Template Method: parse() - defines the algorithm structure
 * - Concrete Methods: open(), close() - common implementations
 * - Abstract Method: processData() - varies by subclass
 */
public abstract class Parser {
    
    /**
     * TEMPLATE METHOD - Defines the skeleton of the parsing algorithm
     * This method controls the overall flow and cannot be overridden
     * Calls both concrete and abstract methods in a specific order
     */
    public final void parse() {
        System.out.println("Starting file parsing process...");
        open();         // Concrete method - common behavior
        processData();  // Abstract method - subclass-specific behavior
        close();        // Concrete method - common behavior
        System.out.println("File parsing completed.");
    }

    /**
     * Concrete method - Common implementation for all parsers
     * Can be overridden by subclasses if needed (hook method)
     */
    protected void open() {
        System.out.println("Opening file for reading...");
    }

    /**
     * Concrete method - Common implementation for all parsers
     * Can be overridden by subclasses if needed (hook method)
     */
    protected void close() {
        System.out.println("Closing file after processing...");
    }

    /**
     * Abstract method - MUST be implemented by subclasses
     * This is where the variation in algorithm occurs
     * Each parser type implements its own data processing logic
     */
    protected abstract void processData();
}
