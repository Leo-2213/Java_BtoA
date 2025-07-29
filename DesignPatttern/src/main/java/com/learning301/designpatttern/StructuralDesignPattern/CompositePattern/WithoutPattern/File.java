package com.learning301.designpatttern.StructuralDesignPattern.CompositePattern.WithoutPattern;

/**
 * File - WITHOUT Composite Pattern
 * 
 * Problems with this approach:
 * 1. NO COMMON INTERFACE - Cannot treat files and folders uniformly
 * 2. DIFFERENT METHOD NAMES - showFile() vs showFiles() in Folder
 * 3. TYPE-SPECIFIC HANDLING - Client must know object type
 * 4. NO POLYMORPHISM - Cannot write generic code for both types
 * 5. POOR EXTENSIBILITY - Adding new types requires client changes
 */
public class File {
    private String fileName;

    /**
     * Constructor for file
     */
    public File(String fileName){
        this.fileName = fileName;
    }

    /**
     * Show file information
     * 
     * PROBLEM: Different method name than Folder.showFiles()
     * Client must remember different method names for different types
     * Cannot write polymorphic code that works with both files and folders
     */
    public void showFile(){
        System.out.println("📄 File: " + fileName);
    }
    
    // MISSING: No common interface with Folder
    // MISSING: Cannot be part of composite structure
    // MISSING: No uniform treatment possible
}
