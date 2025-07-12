package com.learning301.designpatttern.BehaviouralPattern.TemplateMethodPattern.WithoutPattern;

/**
 * JsonParser - WITHOUT Template Method Pattern
 * 
 * Problems:
 * 1. Exact duplicate of CsvParser structure
 * 2. Algorithm duplication - same parse() method logic
 * 3. No shared base class - cannot enforce consistent behavior
 * 4. Maintenance nightmare - changes need to be made in multiple places
 */
public class JsonParser {
    
    /**
     * JSON-specific file opening logic
     * Same concept as CsvParser.open() - code duplication
     */
    public void open(){
        System.out.println("Opening JSON file...");
    }
    
    /**
     * JSON-specific data parsing logic
     * Only this method should actually differ from CsvParser
     */
    public void parseData() {
        System.out.println("Parsing JSON file...");
    }
    
    /**
     * JSON-specific file closing logic
     * Same concept as CsvParser.close() - code duplication
     */
    public void close(){
        System.out.println("Closing JSON file...");
    }

    /**
     * Main parsing method - IDENTICAL to CsvParser.parse()
     * This is the core problem - algorithm duplication
     * Any change to parsing flow requires updates in ALL parser classes
     */
    public void parse() {
        open();      // Common step - duplicated
        parseData(); // Variable step - only real difference
        close();     // Common step - duplicated
    }
}
