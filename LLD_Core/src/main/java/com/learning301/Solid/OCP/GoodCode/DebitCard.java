package com.learning301.Solid.OCP.GoodCode;

public class DebitCard implements PaymentMethod{
    public void pay(double amount){
        System.out.println("Debit card payment done with amount: "+ amount);
    }
}
