package com.learning301.designpatttern.CreationalDesignPattern.BuilderPattern.WithPattern;

/**
 * House - Product Class in Builder Pattern
 * 
 * Complex object that is constructed step-by-step using Builder
 * Demonstrates Builder Pattern benefits:
 * - Immutable object (private constructor, no setters)
 * - Clear construction process
 * - Handles optional parameters elegantly
 * - Avoids telescoping constructor problem
 */
public class House {
    // Product attributes - all final for immutability
    private final String houseType;
    private final Boolean roof;
    private final Boolean hasSwimmingPool;
    private final Boolean hasGarden;
    private final Boolean hasGarage;

    /**
     * Private constructor - only Builder can create House instances
     * 
     * This enforces the use of Builder pattern
     * Ensures object is fully constructed before use
     * 
     * @param houseBuilder the builder containing all house specifications
     */
    private House(HouseBuilder houseBuilder){
        this.houseType = houseBuilder.houseType;
        this.roof = houseBuilder.roof;
        this.hasSwimmingPool = houseBuilder.hasSwimmingPool;
        this.hasGarden = houseBuilder.hasGarden;
        this.hasGarage = houseBuilder.hasGarage;
    }

    /**
     * String representation of the House
     * Shows all configured attributes
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

    /**
     * HouseBuilder - Builder Class (Inner Static Class)
     * 
     * Implements Builder Pattern with fluent interface
     * Allows step-by-step construction of House objects
     * 
     * Key features:
     * - Fluent interface with method chaining
     * - Required parameters in constructor
     * - Optional parameters via setter methods
     * - build() method creates final product
     */
    public static class HouseBuilder{
        // Builder attributes - same as Product
        private String houseType;
        private Boolean roof;
        private Boolean hasSwimmingPool;
        private Boolean hasGarden;
        private Boolean hasGarage;

        /**
         * Constructor for required parameters
         * 
         * Forces client to provide essential house attributes
         * Optional parameters can be set via fluent methods
         * 
         * @param houseType the type of house (required)
         * @param roof whether house has roof (required)
         */
        public HouseBuilder(String houseType, Boolean roof){
            this.houseType = houseType;
            this.roof = roof;
        }

        /**
         * Set swimming pool option (fluent method)
         * 
         * @param flag whether house should have swimming pool
         * @return this builder instance for method chaining
         */
        public HouseBuilder setSwimmingPool(Boolean flag){
            this.hasSwimmingPool = flag;
            return this; // Enables method chaining
        }

        /**
         * Set garden option (fluent method)
         * 
         * @param garden whether house should have garden
         * @return this builder instance for method chaining
         */
        public HouseBuilder setGarden(Boolean garden){
            this.hasGarden = garden;
            return this; // Enables method chaining
        }

        /**
         * Set garage option (fluent method)
         * 
         * @param garage whether house should have garage
         * @return this builder instance for method chaining
         */
        public HouseBuilder setGarage(Boolean garage){
            this.hasGarage = garage;
            return this; // Enables method chaining
        }

        /**
         * Build method - Creates the final House product
         * 
         * This is the terminal operation that creates the House
         * Validates and constructs the final immutable object
         * 
         * @return fully constructed House instance
         */
        public House build(){
            // Could add validation logic here if needed
            return new House(this);
        }
    }
}
