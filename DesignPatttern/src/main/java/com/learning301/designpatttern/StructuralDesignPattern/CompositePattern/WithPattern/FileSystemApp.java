package com.learning301.designpatttern.StructuralDesignPattern.CompositePattern.WithPattern;

/**
 * FileSystemApp - Client demonstrating Composite Pattern
 * 
 * Shows how Composite Pattern enables:
 * - Uniform treatment of individual objects and compositions
 * - Building complex tree structures from simple components
 * - Recursive operations on entire tree with single method call
 * - Client simplicity - no need to distinguish between component types
 * 
 * This demonstrates the power of treating part-whole hierarchies uniformly
 */
public class FileSystemApp {
    public static void main(String[] args) {
        System.out.println("=== Composite Pattern Demonstration ===");
        
        // STEP 1: Create leaf components (files)
        // These are the "parts" in our part-whole hierarchy
        FileSystemComponent file1 = new File("resume.pdf");
        FileSystemComponent file2 = new File("cover_letter.docx");
        FileSystemComponent file3 = new File("portfolio.zip");
        
        System.out.println("\n--- Creating Main Folder Structure ---");
        
        // STEP 2: Create composite (folder) and add files
        // Folder can contain multiple components
        Folder documentsFolder = new Folder("Documents");
        documentsFolder.addComponent(file1);
        documentsFolder.addComponent(file2);
        documentsFolder.addComponent(file3);

        // STEP 3: Create nested structure - folder within folder
        // This demonstrates recursive composition
        System.out.println("\n--- Creating Nested Folder Structure ---");
        
        Folder bankFolder = new Folder("Bank Details");
        FileSystemComponent statement = new File("monthly_statement.pdf");
        FileSystemComponent receipt = new File("payment_receipt.jpg");
        bankFolder.addComponent(statement);
        bankFolder.addComponent(receipt);

        // STEP 4: Create another nested folder
        Folder projectsFolder = new Folder("Projects");
        FileSystemComponent project1 = new File("project_alpha.zip");
        FileSystemComponent project2 = new File("project_beta.tar.gz");
        projectsFolder.addComponent(project1);
        projectsFolder.addComponent(project2);

        // STEP 5: Add subfolders to main folder (composite contains composites)
        // This creates a true tree structure
        documentsFolder.addComponent(bankFolder);
        documentsFolder.addComponent(projectsFolder);

        System.out.println("\n=== Complete File System Structure ===");
        
        // COMPOSITE PATTERN MAGIC: Single method call works on entire tree
        // Client doesn't need to know about the complexity of the structure
        // Same method works whether called on file or folder
        documentsFolder.showComponent();
        
        System.out.println("\n--- Demonstrating Uniform Treatment ---");
        
        // Show that same interface works for individual file
        System.out.println("\nShowing individual file:");
        file1.showComponent();
        
        // And same interface works for complex folder structure
        System.out.println("\nShowing nested folder:");
        bankFolder.showComponent();
        
        System.out.println("\n--- Additional Composite Operations ---");
        
        // Demonstrate additional recursive operations
        System.out.println("Total items in Documents folder: " + documentsFolder.getTotalItems());
        System.out.println("Total items in Bank folder: " + bankFolder.getTotalItems());
        
        System.out.println("\n=== Composite Pattern Benefits Demonstrated ===");
        System.out.println("✅ Uniform treatment - same method for files and folders");
        System.out.println("✅ Recursive composition - folders can contain folders");
        System.out.println("✅ Tree structure - natural hierarchy representation");
        System.out.println("✅ Client simplicity - no type checking needed");
        System.out.println("✅ Polymorphic behavior - interface works for all components");
        System.out.println("✅ Transparent operations - same code works on entire tree");
        
        System.out.println("\n--- What makes this Composite Pattern ---");
        System.out.println("1. Common interface (FileSystemComponent) for all objects");
        System.out.println("2. Leaf objects (File) represent individual items");
        System.out.println("3. Composite objects (Folder) can contain other components");
        System.out.println("4. Recursive operations work on entire tree structure");
        System.out.println("5. Client treats all objects uniformly through interface");
    }
}
