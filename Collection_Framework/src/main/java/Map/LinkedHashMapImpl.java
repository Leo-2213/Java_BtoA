package Map;

import java.util.*;

/*
 * LINKEDHASHMAP OVERVIEW:
 * - Hash table + doubly-linked list implementation of Map interface
 * - Extends HashMap and maintains insertion/access order
 * - Combines HashMap's O(1) performance with predictable iteration order
 * - Two ordering modes: insertion-order (default) and access-order
 * 
 * INTERNAL STRUCTURE:
 * HashMap buckets + Doubly-linked list for ordering
 * 
 * Bucket Array: [0][1][2]...[15] (HashMap structure)
 *                ↓
 * Linked List: Entry1 ↔ Entry2 ↔ Entry3 ↔ Entry4 (maintains order)
 * 
 * ENTRY STRUCTURE:
 * class Entry<K,V> extends HashMap.Node<K,V> {
 *     Entry<K,V> before, after;  // Links for ordering
 * }
 * 
 * ORDERING MODES:
 * 1. Insertion-order (default): Order of key insertion
 * 2. Access-order (accessOrder=true): Order of key access (LRU)
 * 
 * PROS:
 * - Predictable iteration order
 * - O(1) performance like HashMap
 * - Perfect for LRU cache implementation
 * - Maintains insertion order by default
 * 
 * CONS:
 * - Higher memory overhead (extra pointers)
 * - Slightly slower than HashMap (maintaining links)
 * - Not thread-safe
 * 
 * WHEN TO USE:
 * - When you need predictable iteration order
 * - Building LRU caches
 * - When insertion order matters
 * - Configuration maps where order is important
 */
public class LinkedHashMapImpl {
    public static void main(String[] args) {
        // Demonstrate insertion-order vs access-order behavior
        insertionOrderDemo();
        accessOrderDemo();
        
        // Compare with HashMap
        comparisonWithHashMap();
        
        // LRU Cache example
        lruCacheExample();
    }
    
    // Default LinkedHashMap - maintains insertion order
    private static void insertionOrderDemo() {
        System.out.println("=== Insertion-Order LinkedHashMap (Default) ===");
        
        // Default constructor: insertion-order maintained
        LinkedHashMap<String, Integer> insertionOrderMap = new LinkedHashMap<>();
        
        // Add elements - order will be maintained
        insertionOrderMap.put("Banana", 1);
        insertionOrderMap.put("Papaya", 2);
        insertionOrderMap.put("Mango", 3);
        insertionOrderMap.put("Apple", 4);
        
        System.out.println("After insertion (maintains insertion order):");
        printMap(insertionOrderMap);
        
        // Access elements - order remains same in insertion-order mode
        insertionOrderMap.get("Banana");
        insertionOrderMap.get("Mango");
        insertionOrderMap.get("Papaya");
        
        System.out.println("After accessing Banana, Mango, Papaya (order unchanged):");
        printMap(insertionOrderMap);
        
        // Update existing key - maintains position
        insertionOrderMap.put("Banana", 10);
        System.out.println("After updating Banana to 10 (position unchanged):");
        printMap(insertionOrderMap);
        System.out.println();
    }
    
    // Access-order LinkedHashMap - LRU behavior
    private static void accessOrderDemo() {
        System.out.println("=== Access-Order LinkedHashMap (LRU Behavior) ===");
        
        // Constructor with accessOrder=true enables LRU behavior
        LinkedHashMap<String, Integer> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
        
        // Add initial elements
        accessOrderMap.put("Banana", 1);
        accessOrderMap.put("Papaya", 2);
        accessOrderMap.put("Mango", 3);
        accessOrderMap.put("Apple", 4);
        
        System.out.println("Initial insertion order:");
        printMap(accessOrderMap);
        
        // Access elements - this changes their position (moves to end)
        System.out.println("\nAccessing elements (moves them to end - most recently used):");
        
        System.out.println("Accessing Banana...");
        accessOrderMap.get("Banana");  // Moves Banana to end
        printMap(accessOrderMap);
        
        System.out.println("Accessing Mango...");
        accessOrderMap.get("Mango");   // Moves Mango to end
        printMap(accessOrderMap);
        
        System.out.println("Accessing Papaya twice...");
        accessOrderMap.get("Papaya");  // Moves Papaya to end
        accessOrderMap.get("Papaya");  // Papaya stays at end
        printMap(accessOrderMap);
        
        // Put operation also moves to end
        System.out.println("Updating Apple (moves to end):");
        accessOrderMap.put("Apple", 40);
        printMap(accessOrderMap);
        
        System.out.println("Final order (Least Recently Used → Most Recently Used):");
        printMap(accessOrderMap);
        System.out.println();
    }
    
    // Compare LinkedHashMap with HashMap
    private static void comparisonWithHashMap() {
        System.out.println("=== LinkedHashMap vs HashMap Comparison ===");
        
        // HashMap - no guaranteed order
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("First", 1);
        hashMap.put("Second", 2);
        hashMap.put("Third", 3);
        hashMap.put("Fourth", 4);
        
        System.out.println("HashMap (no guaranteed order):");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
        
        // LinkedHashMap - maintains insertion order
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("First", 1);
        linkedHashMap.put("Second", 2);
        linkedHashMap.put("Third", 3);
        linkedHashMap.put("Fourth", 4);
        
        System.out.println("LinkedHashMap (maintains insertion order):");
        printMap(linkedHashMap);
        
        System.out.println("Performance comparison:");
        System.out.println("  HashMap: Faster (no link maintenance)");
        System.out.println("  LinkedHashMap: Slightly slower (maintains links)");
        System.out.println("  Both: O(1) average for get/put operations\n");
    }
    
    // Simple LRU Cache implementation using LinkedHashMap
    private static void lruCacheExample() {
        System.out.println("=== LRU Cache Example ===");
        
        // Create LRU cache with capacity 3
        LinkedHashMap<String, String> lruCache = new LinkedHashMap<String, String>(3, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > 3;  // Remove eldest when size exceeds 3
            }
        };
        
        // Add items to cache
        System.out.println("Adding items to LRU cache (capacity=3):");
        lruCache.put("page1", "Content1");
        lruCache.put("page2", "Content2");
        lruCache.put("page3", "Content3");
        System.out.println("Cache after adding 3 items:");
        printMap(lruCache);
        
        // Access page1 (moves it to end)
        System.out.println("\nAccessing page1 (moves to most recent):");
        lruCache.get("page1");
        printMap(lruCache);
        
        // Add new item - should evict least recently used (page2)
        System.out.println("Adding page4 (should evict least recent - page2):");
        lruCache.put("page4", "Content4");
        printMap(lruCache);
        
        System.out.println("Notice: page2 was automatically removed (LRU eviction)");
        System.out.println();
    }
    
    // Helper method to print map contents
    private static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }
    
    // Overloaded helper for String values
    private static void printMap(LinkedHashMap<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
