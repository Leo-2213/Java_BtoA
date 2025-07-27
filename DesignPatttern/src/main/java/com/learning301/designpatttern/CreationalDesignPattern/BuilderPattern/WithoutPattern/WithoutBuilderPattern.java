package com.learning301.designpatttern.CreationalDesignPattern.BuilderPattern.WithoutPattern;

/**
 * WithoutBuilderPattern - Client showing problems without Builder Pattern
 * 
 * Problems demonstrated:
 * 1. UNCLEAR CODE - Hard to understand what parameters mean
 * 2. PARAMETER CONFUSION - Easy to mix up boolean values
 * 3. INFLEXIBLE - Must provide all parameters in exact order
 * 4. ERROR PRONE - Wrong parameter order causes bugs
 * 5. MAINTENANCE NIGHTMARE - Adding parameters breaks existing code
 */
public class WithoutBuilderPattern {
    public static void main(String[] args) {
        System.out.println("=== WITHOUT Builder Pattern ===");
        
        // PROBLEMATIC OBJECT CREATION
        // What do these boolean values mean? Hard to tell!
        House house1 = new House("courtyard", true, true, true);
        //                         ^type    ^roof ^pool ^garage
        //                         Unclear without comments!
        
        System.out.println("\n--- House 1 (unclear construction) ---");
        System.out.println(house1);
        
        // PARAMETER CONFUSION EXAMPLE
        // Easy to accidentally swap parameters
        House house2 = new House("villa", true, false, true);
        //                        ^type  ^roof ^pool  ^garage
        // What if we meant: pool=true, garage=false?
        // Constructor call doesn't make this clear!
        
        System.out.println("\n--- House 2 (parameter confusion risk) ---");
        System.out.println(house2);
        
        // INFLEXIBILITY PROBLEM
        // What if we only want to set house type and roof?
        // Still must provide all parameters!
        House house3 = new House("apartment", true, false, false);
        //                                           ^forced to specify
        
        System.out.println("\n--- House 3 (forced to specify all params) ---");
        System.out.println(house3);
        
        System.out.println("\n=== Problems with this approach ===");
        System.out.println("❌ Unclear code - hard to understand parameters");
        System.out.println("❌ Parameter confusion - easy to mix up booleans");
        System.out.println("❌ Inflexible - must provide all parameters");
        System.out.println("❌ Error prone - wrong order causes bugs");
        System.out.println("❌ Hard to maintain - adding params breaks code");
        System.out.println("❌ No validation - can create invalid objects");
        
        // DEMONSTRATION OF PARAMETER CONFUSION
        System.out.println("\n--- Parameter Confusion Example ---");
        System.out.println("Which is correct?");
        System.out.println("new House(\"villa\", true, false, true)  // pool=false, garage=true?");
        System.out.println("new House(\"villa\", true, true, false)  // pool=true, garage=false?");
        System.out.println("Without Builder Pattern, it's hard to tell!");
    }
}
