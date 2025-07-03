package com.learning301.Solid.OCP.GoodCode;

public class UPI implements PaymentMethod{
    public void pay(double amount){
        System.out.println("UPI payment done with amount: "+ amount);
    }
}
