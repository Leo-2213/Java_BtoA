package com.learning301.Solid.OCP.GoodCode;

public interface PaymentMethod {
    double amount = 0;
    public void pay(double amount);
}
