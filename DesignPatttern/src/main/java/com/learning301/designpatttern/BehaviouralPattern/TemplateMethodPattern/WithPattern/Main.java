package com.learning301.designpatttern.BehaviouralPattern.TemplateMethodPattern.WithPattern;

/**
 * Client - Main class demonstrating Template Method Pattern
 * 
 * Template Method Pattern Benefits:
 * 1. Code reuse - Common algorithm steps shared
 * 2. Consistency - All parsers follow same structure
 * 3. Maintainability - Algorithm changes in one place
 * 4. Extensibility - Easy to add new parser types
 * 5. Polymorphism - Same interface for all parsers
 */
public class Main {
    public static void main(String[] args) {
        // Create different parser instances
        // Both inherit the same template method parse()
        Parser csvParser = new CSVParser();
        Parser jsonParser = new JsonParser();

        System.out.println("=== CSV Parser ===");
        csvParser.parse(); // Calls template method with CSV-specific processing
        
        System.out.println("\n=== JSON Parser ===");
        jsonParser.parse(); // Calls template method with JSON-specific processing
        
        // Both follow the same algorithm structure:
        // 1. Start parsing
        // 2. Open file
        // 3. Process data (varies by type)
        // 4. Close file
        // 5. Complete parsing
    }
}
