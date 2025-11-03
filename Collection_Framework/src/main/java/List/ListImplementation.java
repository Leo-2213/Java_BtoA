package List;

import java.util.*;

/*
 * ARRAYLIST OVERVIEW:
 * - Resizable array implementation of List interface
 * - Elements stored in contiguous memory (dynamic array)
 * - Default initial capacity: 10, grows by 50% when full
 * 
 * STRUCTURE: [elem0][elem1][elem2][elem3]...[elemN][null][null]...
 * 
 * PROS:
 * - O(1) random access by index (get/set)
 * - O(1) amortized insertion at end
 * - Memory efficient (no extra pointers)
 * - Good cache locality (contiguous memory)
 * - Fast iteration
 * 
 * CONS:
 * - O(n) insertion/deletion in middle (shifting required)
 * - O(n) resizing when capacity exceeded
 * - Wasted memory if size << capacity
 * - Not thread-safe
 * 
 * WHEN TO USE:
 * - Frequent random access by index
 * - More reads than insertions/deletions
 * - When memory efficiency is important
 * - When you know approximate size
 */
public class ListImplementation {
    public static void main(String[] args) {
        // Basic List Operations
        basicOperations();
        
        // List Creation Methods
        listCreationMethods();
        
        // List to Array Conversion
        listToArrayConversion();
        
        // Additional Operations
        additionalOperations();
    }
    
    // Basic add, get, set, remove operations with time complexities
    private static void basicOperations() {
        System.out.println("=== Basic Operations ===");
        List<Integer> list = new ArrayList<>();
        
        // Adding elements - O(1) amortized at end, O(n) if resize needed
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(44);
        list.add(2, 3); // Insert at index 2 - O(n) due to shifting
        
        // Accessing elements - O(1) direct array access
        System.out.println("Element at index 0: " + list.get(0));
        System.out.println("List size: " + list.size());
        
        // Modifying elements - O(1) direct array access
        list.set(4, 50); // Replace element at index 4
        
        // Checking existence - O(n) linear search
        System.out.println("Contains 2: " + list.contains(2));
        System.out.println("Index of 4: " + list.indexOf(4));
        
        // Removing elements - O(n) due to shifting after removal
        list.remove(Integer.valueOf(2)); // Remove first occurrence of 2
        list.remove(0); // Remove element at index 0
        
        System.out.println("Final list: " + list);
        System.out.println();
    }
    
    // Different ways to create lists
    private static void listCreationMethods() {
        System.out.println("=== List Creation Methods ===");
        
        // Mutable ArrayList
        List<String> mutableList = new ArrayList<>(Arrays.asList("abhi", "jeet"));
        mutableList.add("new");
        
        // Fixed-size list (can modify but not add/remove)
        List<String> fixedList = Arrays.asList("fixed", "size");
        fixedList.set(1, "modified");
        
        // Immutable list
        List<Integer> immutableList = List.of(1, 2, 3, 4, 5);
        
        System.out.println("Mutable: " + mutableList);
        System.out.println("Fixed: " + fixedList);
        System.out.println("Immutable: " + immutableList);
        System.out.println();
    }
    
    // Converting list to array
    private static void listToArrayConversion() {
        System.out.println("=== List to Array Conversion ===");
        List<Integer> list = Arrays.asList(1, 2, 4);
        
        // To Object array
        Object[] objArray = list.toArray();
        
        // To typed array
        Integer[] intArray = list.toArray(new Integer[0]);
        
        System.out.println("Object array: " + Arrays.toString(objArray));
        System.out.println("Integer array: " + Arrays.toString(intArray));
        System.out.println();
    }
    
    // Additional useful operations
    private static void additionalOperations() {
        System.out.println("=== Additional Operations ===");
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
        
        // Sorting
        List<Integer> sortedList = new ArrayList<>(list);
        sortedList.sort(null); // Natural order
        System.out.println("Sorted: " + sortedList);
        
        // Reverse sorting
        List<Integer> reverseSorted = new ArrayList<>(list);
        reverseSorted.sort(Collections.reverseOrder());
        System.out.println("Reverse sorted: " + reverseSorted);
        
        // Sublist
        System.out.println("Sublist (1-3): " + list.subList(1, 4));
        
        // Clear and isEmpty
        List<Integer> tempList = new ArrayList<>(list);
        System.out.println("Is empty: " + tempList.isEmpty());
        tempList.clear();
        System.out.println("After clear, is empty: " + tempList.isEmpty());
        
        // List operations
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        list.addAll(list2); // Add all elements
        System.out.println("After addAll: " + list);
        
        list.removeAll(list2); // Remove all matching elements
        System.out.println("After removeAll: " + list);
    }
}
