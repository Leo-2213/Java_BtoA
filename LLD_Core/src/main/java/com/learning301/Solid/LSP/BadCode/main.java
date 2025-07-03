package com.learning301.Solid.LSP.BadCode;

/**
 * Main class demonstrating a violation of the Liskov Substitution Principle.
 * This example shows how a poor class hierarchy design leads to unexpected behavior
 * when substituting a subtype (Ostrich) for its base type (Bird).
 */
public class main {
    public static void main(String[] args) {
        // Using Cookoo as a Bird works fine
        Bird cookoo1 = new Cookoo();
        cookoo1.fly();  // Works as expected
        cookoo1.eat();  // Works as expected

        // Using Ostrich as a Bird causes problems
        Bird ostrich1 = new Ostrich();
        ostrich1.eat();  // Works as expected
        ostrich1.fly();  // LSP violation: either misleading output or exception
                         // This demonstrates that Ostrich cannot be substituted for Bird
    }
}
