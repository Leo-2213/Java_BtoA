package List;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * COMPARATOR OVERVIEW:
 * - Functional interface for defining custom sorting logic
 * - compare(T o1, T o2) returns: negative (o1<o2), zero (o1==o2), positive (o1>o2)
 * - Enables sorting of objects that don't implement Comparable
 * - Allows multiple sorting strategies for same class
 * 
 * SORTING ALGORITHMS:
 * - Collections.sort() uses TimSort (hybrid merge-insertion sort)
 * - Time Complexity: O(n log n) average and worst case
 * - Space Complexity: O(n) for merge operations
 * - Stable sort (maintains relative order of equal elements)
 * 
 * IMPLEMENTATION APPROACHES:
 * 1. Custom classes implementing Comparator
 * 2. Lambda expressions (Java 8+)
 * 3. Method references
 * 4. Comparator utility methods (comparing, thenComparing)
 * 
 * BEST PRACTICES:
 * - Use Integer.compare() instead of subtraction to avoid overflow
 * - Chain comparators with thenComparing() for multi-field sorting
 * - Use Comparator.naturalOrder() for natural ordering
 */

// Custom comparator for ascending integer sorting
class MyComparatorAscending implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1, o2); // Safe comparison
    }
}

// Custom comparator for string sorting by length (ascending)
class MyComparatorAscendingString implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}

// Custom comparator for descending integer sorting
class MyComparatorDescending implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1); // Safe comparison
    }
}

// Custom comparator for string sorting by length (descending)
class MyComparatorDescendingString implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o2.length(), o1.length());
    }
}

// Student class for demonstrating custom object sorting
class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}

public class ComparatorImpl {
    public static void main(String[] args) {
        // Custom comparator classes for integers
        customComparatorDemo();
        
        // Lambda expressions for sorting
        lambdaComparatorDemo();
        
        // Custom object sorting
        customObjectSorting();
    }
    
    // Demonstrating custom comparator classes - Traditional approach
    private static void customComparatorDemo() {
        System.out.println("=== Custom Comparator Classes ===");
        List<Integer> numbers = new ArrayList<>(List.of(9, 6, 3, 4, 5));
        
        // Sort using custom ascending comparator - O(n log n)
        numbers.sort(new MyComparatorAscending());
        System.out.println("Ascending: " + numbers);
        
        // Sort using custom descending comparator - O(n log n)
        numbers.sort(new MyComparatorDescending());
        System.out.println("Descending: " + numbers);
        
        // String sorting by length
        List<String> strings = new ArrayList<>(List.of("abhi", "jeet", "tmapoojya"));
        strings.sort(new MyComparatorAscendingString());
        System.out.println("By length (asc): " + strings);
        
        strings.sort(new MyComparatorDescendingString());
        System.out.println("By length (desc): " + strings);
        System.out.println();
    }
    
    // Demonstrating lambda expressions - Modern concise approach
    private static void lambdaComparatorDemo() {
        System.out.println("=== Lambda Comparators ===");
        List<Integer> numbers = new ArrayList<>(List.of(9, 6, 3, 4, 5));
        
        // Lambda for ascending sort - More concise than custom classes
        numbers.sort((i1, i2) -> Integer.compare(i1, i2));
        System.out.println("Lambda ascending: " + numbers);
        
        // Lambda for descending sort - Inline logic
        numbers.sort((i1, i2) -> Integer.compare(i2, i1));
        System.out.println("Lambda descending: " + numbers);
        System.out.println();
    }
    
    // Demonstrating custom object sorting - Multiple sorting strategies
    private static void customObjectSorting() {
        System.out.println("=== Custom Object Sorting ===");
        List<Student> students = new ArrayList<>();
        
        students.add(new Student("Lakshay", 69));
        students.add(new Student("Harsh", 89));
        students.add(new Student("Abhijeet", 45));
        students.add(new Student("Vishal", 99));
        
        System.out.println("Original order:");
        students.forEach(System.out::println);
        
        // Sort by marks using lambda - Custom field comparison
        students.sort((s1, s2) -> Integer.compare(s1.marks, s2.marks));
        System.out.println("\nSorted by marks:");
        students.forEach(System.out::println);
        
        // Sort by name using method reference - Cleaner syntax
        students.sort(Comparator.comparing(s -> s.name));
        System.out.println("\nSorted by name:");
        students.forEach(System.out::println);
    }
}
