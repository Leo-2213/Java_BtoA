package com.learning301.designpatttern.CreationalDesignPattern.AbstractFactoryPattern.WithPattern;

/**
 * ABSTRACT FACTORY PATTERN IMPLEMENTATION
 * 
 * This file demonstrates the Abstract Factory Pattern with UI components
 * Pattern creates families of related objects (Windows UI, MacOS UI)
 * Ensures consistency within product families
 */

// ===== ABSTRACT PRODUCTS =====

/**
 * Button - Abstract Product Interface
 * 
 * Defines common interface for all button types
 * Part of the UI component family
 */
interface Button{
    void render();
}

/**
 * ScrollBar - Abstract Product Interface
 * 
 * Defines common interface for all scrollbar types
 * Part of the UI component family
 */
interface ScrollBar{
    void scroll();
}

// ===== CONCRETE PRODUCTS - WINDOWS FAMILY =====

/**
 * WindowsButton - Concrete Product
 * 
 * Windows-specific implementation of Button
 * Part of Windows UI family
 */
class WindowsButton implements Button{
    @Override
    public void render(){
        System.out.println("Rendering Windows Button with Windows look and feel");
    }
}

/**
 * WindowsScrollBar - Concrete Product
 * 
 * Windows-specific implementation of ScrollBar
 * Part of Windows UI family
 */
class WindowsScrollBar implements ScrollBar{
    @Override
    public void scroll() {
        System.out.println("Scrolling with Windows scrollbar style");
    }
}

// ===== CONCRETE PRODUCTS - MACOS FAMILY =====

/**
 * MacOsButton - Concrete Product
 * 
 * MacOS-specific implementation of Button
 * Part of MacOS UI family
 */
class MacOsButton implements Button{
    @Override
    public void render(){
        System.out.println("Rendering MacOS Button with MacOS look and feel");
    }
}

/**
 * MacOsScrollBar - Concrete Product
 * 
 * MacOS-specific implementation of ScrollBar
 * Part of MacOS UI family
 */
class MacOsScrollBar implements ScrollBar{
    @Override
    public void scroll() {
        System.out.println("Scrolling with MacOS scrollbar style");
    }
}

// ===== ABSTRACT FACTORY =====

/**
 * UIFactory - Abstract Factory Class
 * 
 * Defines abstract methods for creating families of related UI objects
 * Each concrete factory will create a consistent family of products
 * This is the core of Abstract Factory Pattern
 * 
 * Note: Changed from interface to abstract class
 * - Allows for shared implementation if needed
 * - Concrete factories extend rather than implement
 * - Can provide default implementations for some methods
 */
abstract class UIFactory{
    /**
     * Create a button specific to the UI family
     * Abstract method - must be implemented by concrete factories
     * @return Button implementation for this UI family
     */
     abstract Button createButton();
    
    /**
     * Create a scrollbar specific to the UI family
     * Abstract method - must be implemented by concrete factories
     * @return ScrollBar implementation for this UI family
     */
    abstract ScrollBar createScrollBar();
}

// ===== CONCRETE FACTORIES =====

/**
 * WindowsFactory - Concrete Factory
 * 
 * Extends UIFactory abstract class
 * Creates Windows-specific UI components
 * Ensures all created objects belong to Windows family
 * Guarantees consistency within the family
 */
class WindowsFactory extends UIFactory{

    /**
     * Creates Windows-specific button
     * Overrides abstract method from UIFactory
     */
    @Override
    public Button createButton() {
        return new WindowsButton(); // Creates Windows-specific button
    }

    /**
     * Creates Windows-specific scrollbar
     * Overrides abstract method from UIFactory
     */
    @Override
    public ScrollBar createScrollBar() {
        return new WindowsScrollBar(); // Creates Windows-specific scrollbar
    }
}

/**
 * MacOsFactory - Concrete Factory
 * 
 * Extends UIFactory abstract class
 * Creates MacOS-specific UI components
 * Ensures all created objects belong to MacOS family
 * Guarantees consistency within the family
 */
class MacOsFactory extends UIFactory{

    /**
     * Creates MacOS-specific button
     * Overrides abstract method from UIFactory
     */
    @Override
    public Button createButton() {
        return new MacOsButton(); // Creates MacOS-specific button
    }

    /**
     * Creates MacOS-specific scrollbar
     * Overrides abstract method from UIFactory
     */
    @Override
    public ScrollBar createScrollBar() {
        return new MacOsScrollBar(); // Creates MacOS-specific scrollbar
    }
}

// ===== CLIENT =====

/**
 * Application - Client using Abstract Factory Pattern
 * 
 * Uses abstract factory to create UI components
 * Doesn't know about concrete product classes
 * Works with products through abstract interfaces
 * 
 * Key benefits:
 * - Can switch entire UI families by changing factory
 * - Guaranteed consistency within UI family
 * - Easy to add new UI families (Linux, Android, etc.)
 */
public class Application {
    private Button button;
    private ScrollBar scrollBar;

    /**
     * Constructor - Receives factory and creates UI components
     * 
     * Factory pattern ensures all components belong to same family
     * Client doesn't know which concrete products are created
     * 
     * @param factory the UI factory to use for creating components
     */
    public Application(UIFactory factory){
        // Factory creates consistent family of products
        button = factory.createButton();       // Could be Windows or MacOS button
        scrollBar = factory.createScrollBar(); // Matching scrollbar from same family
    }

    /**
     * Render the UI components
     * 
     * Client works with abstract interfaces
     * Actual behavior depends on which factory was used
     */
    public void renderUI(){
        System.out.println("--- Rendering UI Components ---");
        button.render();    // Polymorphic call
        scrollBar.scroll(); // Polymorphic call
    }

    /**
     * Main method demonstrating Abstract Factory Pattern
     */
    public static void main(String[] args) {
        System.out.println("=== Abstract Factory Pattern Demonstration ===");
        
        // Create Windows UI application
        System.out.println("\n1. Creating Windows Application:");
        UIFactory windowsFactory = new WindowsFactory();
        Application windowsApp = new Application(windowsFactory);
        windowsApp.renderUI();
        
        // Create MacOS UI application
        System.out.println("\n2. Creating MacOS Application:");
        UIFactory macosFactory = new MacOsFactory();
        Application macosApp = new Application(macosFactory);
        macosApp.renderUI();
        
        System.out.println("\n=== Abstract Factory Pattern Benefits ===");
        System.out.println("✅ Consistent product families (no mixing Windows + MacOS)");
        System.out.println("✅ Easy to switch entire UI families");
        System.out.println("✅ Client decoupled from concrete products");
        System.out.println("✅ Easy to add new UI families (Linux, Android, etc.)");
    }
}