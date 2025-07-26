package com.learning301.designpatttern.CreationalDesignPattern.AbstractFactoryPattern.WithoutPattern;

/**
 * WindowsScroll - WITHOUT Abstract Factory Pattern
 * 
 * Problems:
 * - No common interface with other scrollbars
 * - Client must know about specific scrollbar types
 * - No guarantee of consistency with other Windows components
 */
public class WindowsScroll {
    /**
     * Windows-specific scrollbar behavior
     */
    public void scroll(){
        System.out.println("Windows scroll");
    }
}
