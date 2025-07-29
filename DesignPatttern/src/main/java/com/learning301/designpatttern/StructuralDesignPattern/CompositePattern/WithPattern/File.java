package com.learning301.designpatttern.StructuralDesignPattern.CompositePattern.WithPattern;

/**
 * File - Leaf Component in Composite Pattern
 * 
 * Represents individual objects in the composition that have no children
 * Implements the Component interface to enable uniform treatment
 * 
 * Leaf characteristics:
 * - Has no child components
 * - Implements primitive behavior in the composition
 * - Cannot contain other components
 * - Represents end nodes in the tree structure
 * 
 * In file system analogy: actual files that contain data
 */
public class File implements FileSystemComponent {
    private String fileName;

    /**
     * Constructor for creating a file
     * @param fileName name of the file
     */
    public File(String fileName){
        this.fileName = fileName;
    }

    /**
     * Show file information - Leaf implementation
     * 
     * This is the base case for recursive operations
     * Simply displays the file name without any child processing
     * 
     * Leaf objects define behavior for primitive objects in composition
     */
    @Override
    public void showComponent() {
        System.out.println("📄 File: " + fileName);
    }
}
