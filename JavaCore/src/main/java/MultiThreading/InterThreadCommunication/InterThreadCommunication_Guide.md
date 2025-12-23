# Inter-Thread Communication in Java

## Overview
Inter-thread communication allows threads to coordinate their activities and share data safely. Java provides several mechanisms to achieve this coordination.

## Core Concepts

### 1. Synchronization
- **Purpose**: Prevents race conditions and ensures thread safety
- **Implementation**: `synchronized` keyword on methods or blocks

### 2. Wait-Notify Mechanism
- **Purpose**: Allows threads to pause execution and signal each other
- **Key Methods**: `wait()`, `notify()`, `notifyAll()`

## Essential Methods for Inter-Thread Communication

### Object Class Methods (must be called within synchronized context)

#### `wait()`
```java
public final void wait() throws InterruptedException
```
- Causes current thread to wait until another thread calls `notify()` or `notifyAll()`
- Releases the lock on the object
- Thread enters WAITING state

#### `notify()`
```java
public final void notify()
```
- Wakes up a single thread waiting on the object's monitor
- Which thread is awakened is arbitrary
- Does not release the lock immediately

#### `notifyAll()`
```java
public final void notifyAll()
```
- Wakes up all threads waiting on the object's monitor
- More robust than `notify()` for multiple waiting threads

### Thread Class Methods

#### `sleep(long millis)`
```java
public static void sleep(long millis) throws InterruptedException
```
- Pauses current thread for specified time
- Does NOT release locks
- Thread enters TIMED_WAITING state

#### `join()`
```java
public final void join() throws InterruptedException
```
- Waits for thread to complete execution
- Useful for thread coordination

#### `yield()`
```java
public static void yield()
```
- Suggests scheduler to give other threads a chance
- No guarantee of behavior

## Communication Patterns

### 1. Producer-Consumer Pattern
```java
class SharedBuffer {
    private int data;
    private boolean hasData = false;
    
    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait(); // Wait until consumed
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + data);
        notify(); // Signal consumer
    }
    
    public synchronized int consume() throws InterruptedException {
        while (!hasData) {
            wait(); // Wait until produced
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify(); // Signal producer
        return data;
    }
}
```

### 2. Thread Coordination with join()
```java
Thread worker = new Thread(() -> {
    // Do some work
    System.out.println("Work completed");
});

worker.start();
worker.join(); // Wait for worker to complete
System.out.println("Main thread continues");
```

### 3. Conditional Waiting
```java
class ConditionalResource {
    private boolean condition = false;
    
    public synchronized void waitForCondition() throws InterruptedException {
        while (!condition) {
            wait();
        }
        // Proceed when condition is true
    }
    
    public synchronized void setCondition() {
        condition = true;
        notifyAll(); // Wake up all waiting threads
    }
}
```

## Best Practices

### 1. Always use while loops with wait()
```java
// CORRECT
while (!condition) {
    wait();
}

// INCORRECT - vulnerable to spurious wakeups
if (!condition) {
    wait();
}
```

### 2. Prefer notifyAll() over notify()
- `notifyAll()` is safer when multiple threads might be waiting
- `notify()` can lead to deadlocks in complex scenarios

### 3. Keep synchronized blocks minimal
```java
// GOOD - minimal critical section
synchronized (lock) {
    sharedData.update();
}
processData(); // Outside synchronized block

// AVOID - unnecessarily long critical section
synchronized (lock) {
    sharedData.update();
    processData(); // This doesn't need synchronization
}
```

### 4. Handle InterruptedException properly
```java
try {
    wait();
} catch (InterruptedException e) {
    Thread.currentThread().interrupt(); // Restore interrupt status
    throw new RuntimeException(e);
}
```

## Modern Alternatives

### 1. java.util.concurrent Package
- `BlockingQueue` - Thread-safe queues
- `CountDownLatch` - Thread coordination
- `Semaphore` - Resource access control
- `CyclicBarrier` - Synchronization point

### 2. Example with BlockingQueue
```java
BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

// Producer
queue.put(data); // Blocks if queue is full

// Consumer  
int data = queue.take(); // Blocks if queue is empty
```

## Common Pitfalls

1. **Calling wait/notify outside synchronized context** - Throws IllegalMonitorStateException
2. **Using notify() instead of notifyAll()** - Can cause missed signals
3. **Not using while loops with wait()** - Vulnerable to spurious wakeups
4. **Deadlocks** - Multiple threads waiting for each other
5. **Race conditions** - Unsynchronized access to shared data

## Summary

Your InterThreadCommunication.java example demonstrates the fundamental concepts perfectly:
- Synchronized methods for thread safety
- wait/notify for coordination
- Proper state management with boolean flags
- Classic Producer-Consumer pattern implementation

This forms the foundation for understanding more advanced concurrency utilities in Java.