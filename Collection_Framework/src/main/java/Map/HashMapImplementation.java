package Map;

import java.util.*;

/*
 * HASHMAP OVERVIEW:
 * - Hash table implementation of Map interface (key-value pairs)
 * - Uses array of buckets with linked lists/red-black trees for collision handling
 * - Default initial capacity: 16, load factor: 0.75
 * - Allows one null key and multiple null values
 * 
 * INTERNAL STRUCTURE:
 * Bucket Array: [0][1][2]...[15] (default size 16)
 * Each bucket: LinkedList → Red-Black Tree (when > 8 elements)
 * 
 * HASHING MECHANISM:
 * 1. key.hashCode() → hash value
 * 2. hash % bucketSize → bucket index
 * 3. Store/retrieve from that bucket
 * 
 * COLLISION HANDLING:
 * - Separate chaining with linked lists
 * - Tree-ification when bucket size > 8 (Java 8+)
 * - Converts back to list when size < 6
 * 
 * PROS:
 * - O(1) average time for get/put operations
 * - Flexible key types (any Object)
 * - Allows null key/values
 * - Good performance for most use cases
 * 
 * CONS:
 * - O(n) worst case (all keys hash to same bucket)
 * - No ordering of elements
 * - Not thread-safe
 * - Memory overhead for hash table structure
 * 
 * WHEN TO USE:
 * - Fast key-based lookups needed
 * - No ordering requirements
 * - Single-threaded or externally synchronized
 * - When you need null keys/values
 */

public class HashMapImplementation {
    public static void main(String[] args) {
        // Basic HashMap Operations
        basicOperations();
        
        // HashMap-specific features
        hashMapFeatures();
        
        // Iteration methods
        iterationMethods();
        
        // Performance and collision handling
        performanceDemo();
        
        // Common use cases
        useCases();
    }
    
    // Basic CRUD operations - average O(1) time complexity
    private static void basicOperations() {
        System.out.println("=== Basic Operations ===");
        HashMap<Integer, String> map = new HashMap<>();
        
        // Put operations - O(1) average, O(n) worst case
        map.put(3, "Sarah");
        map.put(4, "Lakshay");
        map.put(1, "Abhijeet");
        map.put(2, "Vishal");
        map.put(5, "Harsh");
        System.out.println("After puts: " + map);
        System.out.println("Note: No insertion order maintained");
        
        // Get operations - O(1) average
        System.out.println("Get key 3: " + map.get(3));
        System.out.println("Get non-existent key 10: " + map.get(10));
        
        // Update existing key - O(1) average
        String oldValue = map.put(3, "Sona");
        System.out.println("Updated key 3, old value: " + oldValue);
        System.out.println("After update: " + map);
        
        // Remove operations - O(1) average
        String removed = map.remove(5);
        System.out.println("Removed key 5, value: " + removed);
        System.out.println("After removal: " + map);
        
        // Size and containment checks - O(1)
        System.out.println("Size: " + map.size());
        System.out.println("Contains key 2: " + map.containsKey(2));
        System.out.println("Contains value 'Vishal': " + map.containsValue("Vishal"));
        System.out.println();
    }
    
    // HashMap-specific features (null handling, etc.)
    private static void hashMapFeatures() {
        System.out.println("=== HashMap Features ===");
        HashMap<Integer, String> map = new HashMap<>();
        
        // Null key handling - only one null key allowed
        map.put(null, "Shyam");
        map.put(null, "Mehul"); // Overwrites previous null key
        System.out.println("Null key (only one allowed): " + map);
        
        // Null values - multiple null values allowed
        map.put(1, null);
        map.put(2, null);
        map.put(3, "Valid");
        System.out.println("Multiple null values allowed: " + map);
        
        // Initial capacity and load factor
        HashMap<String, Integer> customMap = new HashMap<>(32, 0.8f);
        System.out.println("Custom capacity (32) and load factor (0.8)");
        
        // Bulk operations
        Map<String, Integer> source = Map.of("A", 1, "B", 2, "C", 3);
        customMap.putAll(source);
        System.out.println("After putAll: " + customMap);
        System.out.println();
    }
    
    // Different ways to iterate through HashMap
    private static void iterationMethods() {
        System.out.println("=== Iteration Methods ===");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);
        
        // 1. KeySet iteration - O(n)
        System.out.println("1. KeySet iteration:");
        for (String key : map.keySet()) {
            System.out.println("   " + key + " = " + map.get(key));
        }
        
        // 2. EntrySet iteration - O(n), more efficient
        System.out.println("2. EntrySet iteration (recommended):");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("   " + entry.getKey() + " = " + entry.getValue());
        }
        
        // 3. Values iteration - O(n)
        System.out.println("3. Values only:");
        for (Integer value : map.values()) {
            System.out.println("   Value: " + value);
        }
        
        // 4. Java 8 forEach - O(n)
        System.out.println("4. Java 8 forEach:");
        map.forEach((key, value) -> System.out.println("   " + key + " -> " + value));
        System.out.println();
    }
    
    // Performance characteristics and collision handling
    private static void performanceDemo() {
        System.out.println("=== Performance & Collision Handling ===");
        
        // Hash collision example
        System.out.println("Hash Collision Example:");
        System.out.println("String 'Aa'.hashCode(): " + "Aa".hashCode());
        System.out.println("String 'BB'.hashCode(): " + "BB".hashCode());
        System.out.println("Both hash to same value - collision!");
        
        HashMap<String, String> collisionMap = new HashMap<>();
        collisionMap.put("Aa", "Value1");
        collisionMap.put("BB", "Value2");
        System.out.println("Collision map: " + collisionMap);
        System.out.println("HashMap handles collisions with chaining");
        
        // Load factor impact
        System.out.println("\nLoad Factor Impact:");
        System.out.println("Default load factor: 0.75");
        System.out.println("Resize when: size > capacity * loadFactor");
        System.out.println("Lower load factor: Less collisions, more memory");
        System.out.println("Higher load factor: More collisions, less memory");
        
        // Tree-ification (Java 8+)
        System.out.println("\nTree-ification (Java 8+):");
        System.out.println("Bucket converts to Red-Black Tree when > 8 elements");
        System.out.println("Converts back to LinkedList when < 6 elements");
        System.out.println("Improves worst-case from O(n) to O(log n)");
        System.out.println();
    }
    
    // Common use cases and patterns
    private static void useCases() {
        System.out.println("=== Common Use Cases ===");
        
        // 1. Caching/Memoization
        System.out.println("1. Caching/Memoization:");
        HashMap<String, String> cache = new HashMap<>();
        cache.put("user:123", "John Doe");
        cache.put("user:456", "Jane Smith");
        System.out.println("   User cache: " + cache);
        
        // 2. Counting occurrences
        System.out.println("\n2. Counting Occurrences:");
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("   Word count: " + wordCount);
        
        // 3. Index mapping
        System.out.println("\n3. Index Mapping:");
        String[] names = {"Alice", "Bob", "Charlie"};
        HashMap<String, Integer> nameToIndex = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            nameToIndex.put(names[i], i);
        }
        System.out.println("   Name to index: " + nameToIndex);
        
        // 4. Configuration/Properties
        System.out.println("\n4. Configuration Storage:");
        HashMap<String, String> config = new HashMap<>();
        config.put("database.url", "jdbc:mysql://localhost:3306/db");
        config.put("database.user", "admin");
        config.put("max.connections", "100");
        System.out.println("   Config: " + config);
        
        System.out.println("\nBEST PRACTICES:");
        System.out.println("- Use entrySet() for iteration (more efficient)");
        System.out.println("- Override hashCode() and equals() for custom keys");
        System.out.println("- Consider initial capacity for known size");
        System.out.println("- Use ConcurrentHashMap for thread safety");
        System.out.println("- Prefer immutable keys to avoid issues");
    }
}
