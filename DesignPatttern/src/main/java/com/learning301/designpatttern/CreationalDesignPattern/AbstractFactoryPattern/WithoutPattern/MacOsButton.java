package com.learning301.designpatttern.CreationalDesignPattern.AbstractFactoryPattern.WithoutPattern;

/**
 * MacOsButton - WITHOUT Abstract Factory Pattern
 * 
 * Problems:
 * - No common interface with other buttons
 * - Client must know about specific button types
 * - Hard to ensure consistency with other MacOS components
 */
public class MacOsButton {
    /**
     * MacOS-specific button rendering
     */
    public void render(){
        System.out.println("Rendering MacOs Button");
    }
}
