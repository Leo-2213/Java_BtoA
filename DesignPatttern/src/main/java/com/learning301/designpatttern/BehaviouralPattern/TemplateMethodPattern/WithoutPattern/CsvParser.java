package com.learning301.designpatttern.BehaviouralPattern.TemplateMethodPattern.WithoutPattern;

/**
 * CsvParser - WITHOUT Template Method Pattern
 * 
 * Problems:
 * 1. Code duplication - Same algorithm structure as JsonParser
 * 2. No inheritance - Cannot leverage common behavior
 * 3. Maintenance issues - Algorithm changes need updates in multiple places
 * 4. Inconsistency risk - Each parser might implement different flow
 */
public class CsvParser {
    
    /**
     * CSV-specific file opening logic
     * Duplicated concept across all parsers
     */
    public void open(){
        System.out.println("Opening CSV file...");
    }
    
    /**
     * CSV-specific data parsing logic
     * Only this method should vary between parsers
     */
    public void parseData() {
        System.out.println("Parsing CSV file...");
    }
    
    /**
     * CSV-specific file closing logic
     * Duplicated concept across all parsers
     */
    public void close(){
        System.out.println("Closing CSV file...");
    }

    /**
     * Main parsing method - defines algorithm structure
     * This exact same structure is repeated in JsonParser
     * Violates DRY principle
     */
    public void parse() {
        open();      // Common step
        parseData(); // Variable step
        close();     // Common step
    }
}
