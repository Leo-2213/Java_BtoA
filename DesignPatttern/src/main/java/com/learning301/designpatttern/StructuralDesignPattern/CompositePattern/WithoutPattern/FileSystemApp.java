package com.learning301.designpatttern.StructuralDesignPattern.CompositePattern.WithoutPattern;

/**
 * FileSystemApp - WITHOUT Composite Pattern
 * 
 * Problems demonstrated:
 * 1. FLAT STRUCTURE ONLY - Cannot create nested folders
 * 2. TYPE-SPECIFIC HANDLING - Must treat files and folders differently
 * 3. DIFFERENT INTERFACES - Files and folders have different methods
 * 4. NO UNIFORM OPERATIONS - Cannot write generic code for both types
 * 5. LIMITED FUNCTIONALITY - Cannot represent complex hierarchies
 * 6. POOR EXTENSIBILITY - Hard to add new component types
 */
public class FileSystemApp {
    public static void main(String[] args) {
        System.out.println("=== WITHOUT Composite Pattern ===");
        
        // Create individual files
        File file1 = new File("resume.pdf");
        File file2 = new File("cover_letter.docx");
        File file3 = new File("portfolio.zip");

        // Create folder and add files
        Folder documentsFolder = new Folder("Documents");
        documentsFolder.addFile(file1);
        documentsFolder.addFile(file2);
        documentsFolder.addFile(file3);

        System.out.println("\n--- Flat Structure Only ---");
        documentsFolder.showFiles(); // Must use specific method for folders
        
        System.out.println("\n--- Showing Individual File ---");
        file1.showFile(); // Must use different method for files
        
        System.out.println("\n=== Problems with this approach ===");
        
        // PROBLEM 1: Cannot create nested structures
        System.out.println("❌ Cannot create folders within folders");
        System.out.println("   - No way to add Folder to another Folder");
        System.out.println("   - Limited to flat, single-level structure");
        
        // PROBLEM 2: Different interfaces
        System.out.println("❌ Files and folders have different methods");
        System.out.println("   - file.showFile() vs folder.showFiles()");
        System.out.println("   - Client must know object type to call correct method");
        
        // PROBLEM 3: No uniform treatment
        System.out.println("❌ Cannot treat files and folders uniformly");
        System.out.println("   - Cannot write generic code that works with both");
        System.out.println("   - Must handle each type separately");
        
        // PROBLEM 4: Type checking required
        System.out.println("❌ Client must perform type checking");
        System.out.println("   - if (object instanceof File) file.showFile()");
        System.out.println("   - if (object instanceof Folder) folder.showFiles()");
        
        // PROBLEM 5: No recursive operations
        System.out.println("❌ Cannot perform recursive operations");
        System.out.println("   - No way to traverse nested structures");
        System.out.println("   - Cannot implement operations like 'find all files'");
        
        System.out.println("\n--- What we CANNOT do ---");
        System.out.println("1. Create nested folder structures");
        System.out.println("2. Write polymorphic code for files and folders");
        System.out.println("3. Perform recursive operations on tree structures");
        System.out.println("4. Add new component types easily");
        System.out.println("5. Treat individual objects and compositions uniformly");
        
        System.out.println("\n--- Imagine trying to represent this structure ---");
        System.out.println("Documents/");
        System.out.println("  ├── resume.pdf");
        System.out.println("  ├── BankDetails/");
        System.out.println("  │   ├── statement.pdf");
        System.out.println("  │   └── receipt.jpg");
        System.out.println("  └── Projects/");
        System.out.println("      ├── project1.zip");
        System.out.println("      └── project2.tar.gz");
        System.out.println("\nThis is IMPOSSIBLE without Composite Pattern!");
    }
}
