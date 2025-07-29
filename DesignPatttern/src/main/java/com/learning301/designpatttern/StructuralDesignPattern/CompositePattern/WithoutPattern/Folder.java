package com.learning301.designpatttern.StructuralDesignPattern.CompositePattern.WithoutPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Folder - WITHOUT Composite Pattern
 * 
 * Problems with this approach:
 * 1. LIMITED COMPOSITION - Can only contain files, not other folders
 * 2. NO COMMON INTERFACE - Different interface than File class
 * 3. FLAT STRUCTURE ONLY - Cannot create nested folder hierarchies
 * 4. TYPE-SPECIFIC METHODS - Must use different methods for files vs folders
 * 5. NO RECURSIVE OPERATIONS - Cannot perform operations on tree structures
 * 6. POOR EXTENSIBILITY - Hard to add new component types
 */
public class Folder {
    private String folderName;
    
    // MAJOR LIMITATION: Can only hold File objects, not other Folders
    // This prevents creating nested folder structures
    // No recursive composition possible
    private List<File> files = new ArrayList<>();

    /**
     * Constructor for folder
     */
    public Folder(String folderName){
        this.folderName = folderName;
    }

    /**
     * Show all files in folder
     * 
     * PROBLEMS:
     * - Different method name than File.showFile()
     * - Cannot show nested folder structures
     * - Client must handle files and folders differently
     * - No polymorphic behavior possible
     */
    public void showFiles(){
        System.out.println("📁 Folder: " + folderName);
        for(File file : files){
            System.out.print("  ");
            file.showFile(); // Must call specific method for files
        }
    }

    /**
     * Add file to folder
     * 
     * LIMITATION: Can only add files, not other folders
     * This prevents building complex tree structures
     */
    public void addFile(File file) {
        files.add(file);
    }
    
    // MISSING FUNCTIONALITY:
    // - Cannot add other folders (no addFolder method possible)
    // - Cannot create nested structures
    // - No common interface with File
    // - No uniform treatment possible
    // - No recursive operations
    
    /**
     * Get all files in folder
     * @return list of files (cannot return folders - they don't exist here)
     */
    public List<File> getFiles() {
        return new ArrayList<>(files);
    }
    
    // What we CANNOT do without Composite Pattern:
    // public void addFolder(Folder folder) - Not possible!
    // public List<Object> getAllComponents() - No common type!
    // Recursive operations on nested structures - Not supported!
}
