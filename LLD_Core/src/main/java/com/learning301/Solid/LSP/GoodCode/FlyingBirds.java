package com.learning301.Solid.LSP.GoodCode;

/**
 * Specialized interface for birds that can fly.
 * This follows LSP by creating a proper hierarchy where flying capability
 * is only expected from birds that can actually fly.
 */
public interface FlyingBirds extends Bird {
    /**
     * Only birds that can fly will implement this interface
     */
    void fly();
}
