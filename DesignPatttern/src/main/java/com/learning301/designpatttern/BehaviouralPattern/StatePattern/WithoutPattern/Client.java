package com.learning301.designpatttern.BehaviouralPattern.StatePattern.WithoutPattern;

public class Client {
    public static void main(String[] args) {
        DirectionService directionService = new DirectionService(TransportationMode.TRAIN);

        directionService.getDirection();
        directionService.getETA();
        directionService.setTransportationMode(TransportationMode.CAR);
        directionService.getDirection();
        directionService.getETA();
    }
}