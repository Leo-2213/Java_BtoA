package com.learning301.designpatttern.BehaviouralPattern.TemplateMethodPattern.WithPattern;

/**
 * Concrete Class - JsonParser
 * 
 * Extends Parser and provides JSON-specific implementation
 * Inherits the template method parse() with its defined algorithm
 * Only needs to implement the abstract processData() method
 * 
 * Benefits:
 * - Reuses common parsing logic (open, close)
 * - Only implements what's different (JSON processing)
 * - Follows the algorithm structure defined in parent
 */
public class JsonParser extends Parser{

    /**
     * JSON-specific implementation of data processing
     * This method is called by the template method parse()
     * Implements the variable part of the algorithm
     */
    @Override
    protected void processData() {
        System.out.println("Processing JSON data: parsing key-value pairs...");
        // In real implementation, this would contain JSON parsing logic:
        // - Parse nested objects
        // - Handle arrays
        // - Validate JSON syntax
        // - Convert to appropriate data structures
    }
}
