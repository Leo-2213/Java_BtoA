# Synchronized Methods in Java - Complete Guide

## Overview
Synchronized methods are a fundamental mechanism in Java for achieving thread safety when multiple threads access shared resources concurrently. The `synchronized` keyword ensures that only one thread can execute a synchronized method on a particular object instance at any given time.

## What is Synchronization?

Synchronization is a mechanism that ensures that multiple threads can safely access shared resources without causing data corruption or inconsistent states. In Java, synchronization is achieved using the `synchronized` keyword.

## The Problem: Race Conditions

Without synchronization, multiple threads accessing shared data can cause **race conditions**:

```java
// WITHOUT synchronization - PROBLEMATIC
class UnsafeCounter {
    private int count = 0;
    
    public void increment() {
        count++; // This is NOT atomic!
    }
}
```

The `count++` operation actually involves three steps:
1. Read the current value of `count`
2. Increment the value
3. Write the new value back to `count`

When multiple threads execute this simultaneously, they can interfere with each other, leading to lost updates.

## The Solution: Synchronized Methods

```java
class SafeCounter {
    private int count = 0;
    
    public synchronized void increment() {
        count++; // Now this is thread-safe!
    }
}
```

## How Synchronized Methods Work

### 1. **Intrinsic Lock (Monitor)**
- Every Java object has an intrinsic lock (also called a monitor)
- When a thread enters a synchronized method, it acquires the object's intrinsic lock
- Other threads trying to enter ANY synchronized method on the same object must wait

### 2. **Lock Acquisition and Release**
```java
public synchronized void method1() {
    // Thread acquires lock here
    // Critical section - only one thread at a time
} // Lock is automatically released here

public synchronized void method2() {
    // Same lock as method1 - mutual exclusion applies
}
```

### 3. **Automatic Lock Management**
- Lock is acquired when entering the method
- Lock is released when:
  - Method completes normally
  - Method throws an exception
  - Method executes a return statement

## Types of Synchronization

### 1. **Instance Method Synchronization**
```java
public synchronized void instanceMethod() {
    // Synchronizes on 'this' object
}
```

### 2. **Static Method Synchronization**
```java
public static synchronized void staticMethod() {
    // Synchronizes on the Class object
}
```

### 3. **Synchronized Blocks**
```java
public void method() {
    synchronized(this) {
        // Synchronized block
    }
}
```

## Example Analysis: ThreadController.java

Let's analyze the provided code:

### Without Synchronization (Hypothetical)
```java
public void increment() {
    count++; // Race condition possible
}
```
**Result**: Unpredictable count (likely < 2000)

### With Synchronization (Actual Code)
```java
public synchronized void increment() {
    count++; // Thread-safe
}
```
**Result**: Predictable count = 2000

## Key Benefits

1. **Thread Safety**: Prevents race conditions
2. **Data Consistency**: Ensures shared data remains in a consistent state
3. **Atomicity**: Makes compound operations atomic
4. **Visibility**: Changes made by one thread are visible to other threads

## Performance Considerations

### Advantages
- Simple to implement
- Automatic lock management
- Built into the language

### Disadvantages
- **Performance overhead**: Lock acquisition/release takes time
- **Blocking**: Threads must wait for lock availability
- **Potential deadlocks**: If not used carefully with multiple locks

## Best Practices

### 1. **Minimize Synchronized Scope**
```java
// Good - minimal synchronization
public void updateCounter() {
    // Non-critical operations here
    synchronized(this) {
        count++; // Only critical section is synchronized
    }
    // More non-critical operations
}
```

### 2. **Consistent Synchronization**
```java
class Counter {
    private int count = 0;
    
    public synchronized void increment() { count++; }
    public synchronized int getCount() { return count; } // Also synchronized!
}
```

### 3. **Avoid Synchronizing on Public Objects**
```java
// Bad
public synchronized void method() { }

// Better
private final Object lock = new Object();
public void method() {
    synchronized(lock) { }
}
```

## Alternative Approaches

### 1. **Volatile Keyword**
```java
private volatile int count; // For simple reads/writes
```

### 2. **Atomic Classes**
```java
private AtomicInteger count = new AtomicInteger(0);
public void increment() {
    count.incrementAndGet(); // Thread-safe without synchronization
}
```

### 3. **Concurrent Collections**
```java
ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
```

## Common Pitfalls

### 1. **Forgetting to Synchronize Getters**
```java
// Problematic - inconsistent synchronization
public synchronized void setCount(int count) { this.count = count; }
public int getCount() { return count; } // Should also be synchronized!
```

### 2. **Synchronizing on Mutable Objects**
```java
// Bad - lock object can change
synchronized(mutableList) { }
```

### 3. **Deadlock Scenarios**
```java
// Potential deadlock if two threads acquire locks in different orders
synchronized(lock1) {
    synchronized(lock2) { }
}
```

## Testing Thread Safety

To verify your synchronized methods work correctly:

1. **Create multiple threads** accessing the same shared resource
2. **Perform many operations** to increase the likelihood of race conditions
3. **Check final state** - should be predictable and consistent
4. **Run multiple times** - results should always be the same

## Conclusion

Synchronized methods are essential for thread-safe programming in Java. While they introduce some performance overhead, they provide a simple and reliable way to prevent race conditions and ensure data consistency in multithreaded applications.

The key is to use synchronization judiciously - synchronize only what needs to be synchronized, and consider alternative approaches like atomic classes or concurrent collections when appropriate.