# Java Multithreading: Synchronized vs Custom Locks

## Overview
This example demonstrates two different approaches to thread synchronization in Java:
1. **Synchronized methods** - Built-in Java synchronization
2. **Custom locks (ReentrantLock)** - Explicit lock management with timeout

## Key Concepts Explained

### 1. Thread Execution vs join() Behavior

**Common Misconception**: `join()` controls thread execution order
**Reality**: `join()` only makes the main thread wait for worker threads to complete

```java
t4.start(); t5.start(); t6.start();  // All threads start CONCURRENTLY
t4.join(); t5.join(); t6.join();     // Main thread waits for ALL to finish
```

**What Actually Happens**:
- All threads begin executing simultaneously
- Synchronization mechanisms (synchronized/locks) control access to shared resources
- `join()` ensures main thread waits for completion before proceeding

### 2. Synchronized Method Behavior

```java
public synchronized void withdraw(int amount)
```

**Characteristics**:
- Only one thread can execute the method at a time
- Other threads **block indefinitely** until current thread finishes
- Guaranteed sequential execution
- All threads will eventually complete their operations

**Output Pattern**:
```
===Attempting Withdrawal===        // Thread1 executes
Amount withdrawal: 5000 Balance: 45000
===Attempting Withdrawal===        // Thread2 waits, then executes
Amount withdrawal: 5000 Balance: 40000
===Attempting Withdrawal===        // Thread3 waits, then executes
Amount withdrawal: 5000 Balance: 35000
```

### 3. Custom Lock (ReentrantLock) Behavior

```java
if(lock.tryLock(5, TimeUnit.SECONDS))
```

**Characteristics**:
- Threads attempt to acquire lock with a **timeout**
- If lock unavailable after timeout, thread gives up
- More flexible but some operations may not complete
- Non-blocking approach

**Output Pattern**:
```
===Attempting Custom Withdrawal===  // All threads start simultaneously
===Attempting Custom Withdrawal===
===Attempting Custom Withdrawal===
Amount withdrawal: 5000 Balance: 45000  // First thread succeeds
Amount withdrawal: 5000 Balance: 40000  // Second thread succeeds
Thread6 Lock acquired, Will try after some time.  // Third thread times out
```

## FAQ - Common Questions Answered

### Q1: Why do all threads start at once despite using join()?
**Answer**: `join()` doesn't control when threads start - it only makes the main thread wait. All threads start concurrently when you call `start()`.

### Q2: Why does the main thread continue even when Thread6 times out?
**Answer**: Thread completion ≠ Successful operation. When Thread6 times out:
1. It prints the timeout message
2. The `run()` method completes normally
3. Thread terminates (even though no withdrawal occurred)
4. `join()` returns because the thread finished

### Q3: How to make threads execute sequentially?
**Answer**: Start and join them one by one:
```java
t4.start(); t4.join();  // Wait for t4 to finish
t5.start(); t5.join();  // Then start and wait for t5
t6.start(); t6.join();  // Finally start and wait for t6
```

## Comparison Table

| Aspect | Synchronized Method | Custom Lock (tryLock) |
|--------|-------------------|---------------------|
| **Waiting Behavior** | Threads block indefinitely | Threads timeout after specified time |
| **Execution Guarantee** | All threads will execute | Some threads may give up |
| **Flexibility** | Less control | More control over timeout |
| **Use Case** | When all operations must complete | When you can handle failed attempts |

## Best Practices

1. **Use synchronized** when you need guaranteed execution of all threads
2. **Use custom locks** when you want to avoid indefinite blocking
3. **Always use try-finally** with explicit locks to ensure proper cleanup
4. **Handle InterruptedException** properly to maintain thread interruption status

## Thread States Timeline

```
Time 0s:  All threads start (RUNNABLE)
Time 0s:  One thread acquires lock, others wait
Time 2s:  First thread completes, releases lock
Time 2s:  Second thread acquires lock
Time 4s:  Second thread completes, releases lock
Time 5s:  Third thread times out, terminates
Time 5s:  All threads TERMINATED, main continues
```

This example perfectly demonstrates the difference between thread lifecycle management and resource synchronization in concurrent programming.