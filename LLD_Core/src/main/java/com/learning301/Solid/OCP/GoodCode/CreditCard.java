package com.learning301.Solid.OCP.GoodCode;

public class CreditCard implements PaymentMethod{

    public void pay(double amount){
        System.out.println("Credit card payment done with amount: "+ amount);

    }
}
