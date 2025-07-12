package com.learning301.designpatttern.BehaviouralPattern.TemplateMethodPattern.WithoutPattern;

/**
 * Client - Main class WITHOUT Template Method Pattern
 * 
 * Problems demonstrated:
 * 1. No polymorphism - Cannot treat parsers uniformly
 * 2. Code duplication - Each parser implements same algorithm structure
 * 3. Maintenance issues - Algorithm changes require multiple updates
 * 4. Inconsistency risk - No guarantee all parsers follow same flow
 * 5. Poor extensibility - Adding new parsers means duplicating code
 */
public class Main {
    public static void main(String[] args) {
        // Must create specific parser types - no common interface
        CsvParser csvParser = new CsvParser();
        JsonParser jsonParser = new JsonParser();
        
        System.out.println("=== CSV Parser ===");
        csvParser.parse(); // Calls duplicated algorithm
        
        System.out.println("\n=== JSON Parser ===");
        jsonParser.parse(); // Calls duplicated algorithm
        
        // Problems:
        // - Cannot use polymorphism (no common base type)
        // - Each parser duplicates the same algorithm structure
        // - If we want to add logging or error handling to the algorithm,
        //   we'd need to modify EVERY parser class
        // - No guarantee that new parsers will follow the same pattern
    }
}
