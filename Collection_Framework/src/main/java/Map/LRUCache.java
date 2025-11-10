package Map;

import java.util.LinkedHashMap;
import java.util.Map;

class LruCacheImpl {
    private final LinkedHashMap<String, Integer> cache;
    private final int capacity;

    LruCacheImpl(int capacity) {
        this.capacity = capacity;
        // LinkedHashMap with access-order and automatic eviction
        this.cache = new LinkedHashMap<String, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > LruCacheImpl.this.capacity;
            }
        };
    }
    
    public int get(String key) {
        return cache.getOrDefault(key, -1);
    }
    
    // Simplified put method - LinkedHashMap handles eviction automatically
    public void put(String key, Integer value) {
        cache.put(key, value);  // That's it! LinkedHashMap handles everything
    }

    public Iterable<? extends Map.Entry<String, Integer>> entrySet() {
        return cache.entrySet();
    }
    
    public int size() {
        return cache.size();
    }
    
    public boolean containsKey(String key) {
        return cache.containsKey(key);
    }
}
public class LRUCache {
    public static void main(String[] args) {
        System.out.println("=== LRU Cache Demo ===");
        LruCacheImpl lruCache = new LruCacheImpl(3);  // Smaller capacity for clearer demo
        
        // Initial puts
        System.out.println("\n1. Adding initial items:");
        lruCache.put("A", 1);
        lruCache.put("B", 2);
        lruCache.put("C", 3);
        printCache("After adding A, B, C", lruCache);
        
        // Access some items (moves them to end - most recently used)
        System.out.println("\n2. Accessing items (updates LRU order):");
        System.out.println("Get A: " + lruCache.get("A"));  // A becomes most recent
        System.out.println("Get B: " + lruCache.get("B"));  // B becomes most recent
        printCache("After accessing A, B", lruCache);
        
        // Add new item - should evict least recently used (C)
        System.out.println("\n3. Adding new item (triggers eviction):");
        lruCache.put("D", 4);  // Should evict C (least recently used)
        printCache("After adding D", lruCache);
        
        // Verify C was evicted
        System.out.println("\n4. Verify eviction:");
        System.out.println("Get C: " + lruCache.get("C"));  // Should return -1 (not found)
        System.out.println("Get A: " + lruCache.get("A"));  // Should return 1
        
        // Update existing key
        System.out.println("\n5. Update existing key:");
        lruCache.put("A", 10);  // Update A's value and make it most recent
        printCache("After updating A to 10", lruCache);
    }
    
    private static void printCache(String message, LruCacheImpl cache) {
        System.out.println(message + ":");
        for (Map.Entry<String, Integer> entry : cache.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("  (Order: Least Recent -> Most Recent)");
    }
}
