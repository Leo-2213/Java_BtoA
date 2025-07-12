package com.learning301.designpatttern.BehaviouralPattern.TemplateMethodPattern.WithPattern;

/**
 * Concrete Class - CSVParser
 * 
 * Extends Parser and provides CSV-specific implementation
 * Inherits the template method parse() with its defined algorithm
 * Only needs to implement the abstract processData() method
 * 
 * Benefits:
 * - Reuses common parsing logic (open, close)
 * - Only implements what's different (CSV processing)
 * - Follows the algorithm structure defined in parent
 */
public class CSVParser extends Parser{

    /**
     * CSV-specific implementation of data processing
     * This method is called by the template method parse()
     * Implements the variable part of the algorithm
     */
    @Override
    protected void processData() {
        System.out.println("Processing CSV data: parsing comma-separated values...");
        // In real implementation, this would contain CSV parsing logic:
        // - Split by commas
        // - Handle quoted fields
        // - Process headers
        // - Validate data types
    }
}
