package com.learning301.Solid.OCP.GoodCode;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        paymentProcessor.processPayment(new CreditCard(), 100.0);
        paymentProcessor.processPayment(new DebitCard(), 50.0);
        paymentProcessor.processPayment(new UPI(), 75.0);
    }
}
