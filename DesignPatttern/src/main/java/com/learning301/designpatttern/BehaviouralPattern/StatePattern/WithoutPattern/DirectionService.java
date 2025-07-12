package com.learning301.designpatttern.BehaviouralPattern.StatePattern.WithoutPattern;

enum TransportationMode {
    TRAIN,CAR,BUS,WALKING
}

public class DirectionService {
    private TransportationMode transportationMode;

    public DirectionService(TransportationMode transportationMode){
        this.transportationMode=transportationMode;
    }

    public void setTransportationMode(TransportationMode transportationMode){
        this.transportationMode = transportationMode;
    }

    public void getDirection(){
        switch (transportationMode){
            case TRAIN:
                System.out.println("Calculating Direction for Train");
                break;
            case CAR:
                System.out.println("Calculating Direction for Car");
                break;
            case BUS:
                System.out.println("Calculating Direction for Bus");
                break;
            case WALKING:
                System.out.println("Calculating Direction for Walking");
                break;
        }
    }
    public void getETA(){
        switch (transportationMode){
            case TRAIN:
                System.out.println("Calculating ETA for Train");
                break;
            case CAR:
                System.out.println("Calculating ETA for Car");
                break;
            case BUS:
                System.out.println("Calculating ETA for Bus");
                break;
            case WALKING:
                System.out.println("Calculating ETA for Walking");
                break;
        }
    }
}