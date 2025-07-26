package com.learning301.designpatttern.CreationalDesignPattern.AbstractFactoryPattern.WithoutPattern;

/**
 * MacOsScroll - WITHOUT Abstract Factory Pattern
 * 
 * Problems:
 * - No common interface with other scrollbars
 * - Client must know about specific scrollbar types
 * - No guarantee of consistency with other MacOS components
 */
public class MacOsScroll {
    /**
     * MacOS-specific scrollbar behavior
     */
    public void scroll(){
        System.out.println("MacOs scroll");
    }
}
