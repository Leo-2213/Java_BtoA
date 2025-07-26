package com.learning301.designpatttern.CreationalDesignPattern.AbstractFactoryPattern.WithoutPattern;

/**
 * Application - WITHOUT Abstract Factory Pattern
 * 
 * Problems with this approach:
 * 1. INCONSISTENT FAMILIES - Can mix Windows and MacOS components
 * 2. TIGHT COUPLING - Client directly depends on concrete classes
 * 3. NO ABSTRACTION - No common interfaces for similar components
 * 4. HARD TO EXTEND - Adding new UI families requires client changes
 * 5. NO FAMILY GUARANTEE - Nothing prevents mixing incompatible components
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("=== WITHOUT Abstract Factory Pattern ===");
        
        // PROBLEM: Client directly creates concrete objects
        // No guarantee of consistency between components
        MacOsScroll macOsScroll = new MacOsScroll();     // MacOS component
        MacOsButton macOsButton = new MacOsButton();     // MacOS component
        
        // DANGER: Could easily mix incompatible families
        // WindowsButton windowsButton = new WindowsButton(); // Windows component
        // This would create inconsistent UI (MacOS scroll + Windows button)
        
        System.out.println("\n--- Using Mixed/Inconsistent Components ---");
        macOsScroll.scroll();
        macOsButton.render();
        
        // Demonstrate the problem of mixing families
        System.out.println("\n--- Demonstrating Family Inconsistency Problem ---");
        WindowsButton windowsButton = new WindowsButton();
        windowsButton.render(); // Now we have MacOS scroll + Windows button!
        
        System.out.println("\n=== Problems with this approach ===");
        System.out.println("❌ Can accidentally mix Windows and MacOS components");
        System.out.println("❌ Client tightly coupled to concrete classes");
        System.out.println("❌ No common interfaces for similar components");
        System.out.println("❌ Hard to switch entire UI families");
        System.out.println("❌ No guarantee of consistent look and feel");
        System.out.println("❌ Difficult to add new UI families");
    }
}
