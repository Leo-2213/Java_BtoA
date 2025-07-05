package com.learning301.designpatttern.BehaviouralPattern.ObserverPattern.WithPattern;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        Observer mobileDevice1 = new MobileDevice("mobile1");
        Observer mobileDevice2 = new MobileDevice("mobile2");
        Observer laptopDevice1 = new LaptopDevice("Laptop 1");
        Observer laptopDevide2 = new LaptopDevice("Laptop 2");


        weatherStation.registerObserver(mobileDevice1);
        weatherStation.registerObserver(mobileDevice2);
        weatherStation.registerObserver(laptopDevice1);
        weatherStation.registerObserver(laptopDevide2);

        System.out.println("initial temperture is "+ weatherStation.getTemperature());

        weatherStation.setTemperature(35.5F);

        weatherStation.removeObserver(mobileDevice2);

        weatherStation.setTemperature(38.5F);

        weatherStation.registerObserver(new LaptopDevice("Laptop 3"));

        weatherStation.removeObserver(laptopDevice1);

        weatherStation.setTemperature(40.5F);


    }
}
