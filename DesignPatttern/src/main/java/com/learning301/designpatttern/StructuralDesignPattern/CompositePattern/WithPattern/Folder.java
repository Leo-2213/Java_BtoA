package com.learning301.designpatttern.StructuralDesignPattern.CompositePattern.WithPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Folder - Composite Component in Composite Pattern
 * 
 * Defines behavior for components having children
 * Can contain other FileSystemComponents (both files and folders)
 * Implements Component interface operations by delegating to children
 * 
 * Composite characteristics:
 * - Can contain child components
 * - Implements child-related operations (add, remove)
 * - Delegates operations to child components
 * - Represents internal nodes in tree structure
 * 
 * This is the key class that enables recursive composition
 */
public class Folder implements FileSystemComponent{
    private String folderName;
    
    // CORE OF COMPOSITE PATTERN: Collection of components
    // Can hold both files (leaves) and folders (composites)
    // This enables recursive tree structure
    private List<FileSystemComponent> components = new ArrayList<>();

    /**
     * Constructor for creating a folder
     * @param folderName name of the folder
     */
    public Folder(String folderName){
        this.folderName = folderName;
    }

    /**
     * Add component to this folder
     * 
     * This method enables building the tree structure
     * Can add both files and other folders
     * Supports unlimited nesting depth
     * 
     * @param component the component to add (file or folder)
     */
    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    /**
     * Remove component from this folder
     * @param component the component to remove
     */
    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    /**
     * Get all components in this folder
     * @return list of all contained components
     */
    public List<FileSystemComponent> getComponents() {
        return new ArrayList<>(components); // Return copy for safety
    }

    /**
     * Show folder and all its contents - Composite implementation
     * 
     * This is where the recursive magic happens:
     * 1. Shows folder name
     * 2. Iterates through all child components
     * 3. Calls showComponent() on each child (polymorphic call)
     * 4. If child is a file: displays file name
     * 5. If child is a folder: recursively shows folder contents
     * 
     * This demonstrates the power of Composite Pattern:
     * - Same operation works on entire tree structure
     * - No need to distinguish between files and folders
     * - Automatic recursive traversal
     */
    @Override
    public void showComponent() {
        System.out.println("📁 Folder: " + folderName);
        
        // Recursive delegation to child components
        // This is the core of Composite Pattern behavior
        for(FileSystemComponent component : components){
            System.out.print("  "); // Indent for visual hierarchy
            component.showComponent(); // Polymorphic call - works for files and folders
        }
    }
    
    /**
     * Get total number of items in folder (including nested items)
     * Demonstrates recursive operations in composite pattern
     */
    public int getTotalItems() {
        int total = components.size();
        
        // Add items from nested folders
        for(FileSystemComponent component : components) {
            if(component instanceof Folder) {
                total += ((Folder) component).getTotalItems();
            }
        }
        
        return total;
    }
}
