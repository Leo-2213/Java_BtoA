package com.learning301.Solid.LSP.GoodCode;

/**
 * Main class demonstrating proper application of the Liskov Substitution Principle.
 * This example shows how to correctly design class hierarchies that respect
 * the behavioral contracts of their types.
 */
public class Main {
    public static void main(String[] args) {
        // Create an Ostrich as a Bird (only has eat capability)
        Bird ostrich = new Ostrich();
        
        // Create a Cookoo as a FlyingBird (has both eat and fly capabilities)
        FlyingBirds cookoo = new Cookoo();

        // Cookoo can both eat and fly
        cookoo.eat();
        cookoo.fly();

        // Ostrich can only eat
        ostrich.eat();
        // We don't attempt to make the ostrich fly, as it doesn't implement FlyingBirds
    }
}
