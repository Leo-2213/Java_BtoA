package com.learning301.designpatttern.StructuralDesignPattern.CompositePattern.WithPattern;

/**
 * FileSystemComponent - Component Interface in Composite Pattern
 * 
 * Defines the common interface for all objects in the composition
 * Both individual objects (files) and compositions (folders) implement this
 * 
 * Key Composite Pattern benefits:
 * - Enables uniform treatment of individual and composite objects
 * - Client can work with complex tree structures using simple interface
 * - Supports recursive composition (folders containing folders)
 * - Polymorphic behavior through common interface
 * 
 * This interface is the foundation that makes the pattern work
 */
public interface FileSystemComponent {
    /**
     * Display component information
     * 
     * This method works polymorphically:
     * - For files: displays file name
     * - For folders: displays folder name and recursively shows all contents
     * 
     * Client can call this on any component without knowing its type
     */
    void showComponent();
}
