package com.learning301.designpatttern.CreationalDesignPattern.BuilderPattern.WithoutPattern;

/**
 * House - WITHOUT Builder Pattern
 * 
 * Problems with this approach:
 * 1. TELESCOPING CONSTRUCTOR - Many parameters hard to remember
 * 2. PARAMETER CONFUSION - Easy to mix up boolean parameters
 * 3. INFLEXIBLE - Must provide all parameters even if not needed
 * 4. HARD TO READ - new House("type", true, false, true) unclear
 * 5. MAINTENANCE ISSUES - Adding parameters breaks existing code
 */
public class House {
    private String houseType;
    private Boolean roof;
    private Boolean hasSwimmingPool;
    private Boolean hasGarden;
    private Boolean hasGarage;

    /**
     * PROBLEMATIC CONSTRUCTOR - Telescoping Constructor Anti-pattern
     * 
     * Issues:
     * - Too many parameters (4 parameters, could be more)
     * - Boolean parameters easy to confuse
     * - Parameter order must be remembered
     * - No way to skip optional parameters
     * - Hard to read: new House("type", true, false, true)
     * - Adding new features requires new constructor or breaking changes
     */
    House(String houseType, Boolean roof, Boolean hasSwimmingPool, Boolean hasGarage){
        this.houseType = houseType;
        this.roof = roof;
        this.hasSwimmingPool = hasSwimmingPool;
        this.hasGarden = true; // PROBLEM: Hardcoded value, not configurable
        this.hasGarage = hasGarage;
    }

    /**
     * String representation of the House
     */
    @Override
    public String toString() {
        return "House{" +
                "houseType='" + houseType + '\'' +
                ", roof=" + roof +
                ", hasSwimmingPool=" + hasSwimmingPool +
                ", hasGarden=" + hasGarden +
                ", hasGarage=" + hasGarage +
                '}';
    }
}
