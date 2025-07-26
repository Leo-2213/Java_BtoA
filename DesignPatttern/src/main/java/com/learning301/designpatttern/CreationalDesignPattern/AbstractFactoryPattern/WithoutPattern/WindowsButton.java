package com.learning301.designpatttern.CreationalDesignPattern.AbstractFactoryPattern.WithoutPattern;

/**
 * WindowsButton - WITHOUT Abstract Factory Pattern
 * 
 * Problems:
 * - No common interface with other buttons
 * - Client must know about specific button types
 * - Hard to ensure consistency with other Windows components
 */
public class WindowsButton{
    /**
     * Windows-specific button rendering
     */
    public void render(){
        System.out.println("Rendering Windows Button");
    }
}
