package com.learning301.designpatttern.BehaviouralPattern.ObserverPattern.WithoutPattern;

import java.util.List;

/**
 * WeatherStation - A simple implementation without using the Observer pattern
 * This class demonstrates the limitations of not using the Observer pattern:
 * 1. Tight coupling between WeatherStation and DisplayDevices
 * 2. Limited flexibility for adding/removing devices at runtime
 * 3. All devices must be of the same type (DisplayDevices)
 */
class WeatherStation{
    private float temp;
    private List<DisplayDevices> displayDevices;

    /**
     * Constructor requires a list of all devices at creation time
     * This creates tight coupling and makes dynamic changes difficult
     */
    public WeatherStation(List<DisplayDevices> displayDevices) {
        this.displayDevices = displayDevices;
    }

    /**
     * Updates temperature and notifies all devices
     * Cannot easily add or remove devices after initialization
     */
    public void setTemp(float temp) {
        this.temp = temp;
        System.out.println("WeatherStation: new temp measurement: " + temp + " C");
        notifyDevice();
    }

    /**
     * Notifies all devices about temperature change
     * Limited to working with only DisplayDevices objects
     */
    public void notifyDevice(){
        displayDevices.forEach(device -> device.showTemp(temp));
    }
}

/**
 * DisplayDevices - A simple display device implementation
 * All devices must be of this type, limiting flexibility
 */
class DisplayDevices{
    public void showTemp(float temp){
        System.out.println("Displaying temp: "+temp + " C");
    }
}

/**
 * WithoutObserverPattern - Demonstrates a simple implementation without the Observer pattern
 * This example shows the limitations when not using proper design patterns
 */
public class WithoutObserverPattern {
    public static void main(String[] args) {
        // Create display devices
        DisplayDevices displayDevices1 = new DisplayDevices();
        DisplayDevices displayDevices2 = new DisplayDevices();
        DisplayDevices displayDevices3 = new DisplayDevices();
        
        // Must provide all devices at creation time
        // Cannot easily add or remove devices later
        WeatherStation weatherStation = new WeatherStation(List.of(displayDevices1, displayDevices2, displayDevices3));

        // Update temperature - all devices are notified
        weatherStation.setTemp(34.5F);
        weatherStation.setTemp(35.5F);
        
        // Note: There's no easy way to add a new device or remove an existing one at this point
    }
}
