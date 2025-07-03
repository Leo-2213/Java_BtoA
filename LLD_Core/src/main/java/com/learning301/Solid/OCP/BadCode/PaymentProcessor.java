package com.learning301.Solid.OCP.BadCode;

public class PaymentProcessor {
    public void processPayment(String paymentType, double amount) {
        if (paymentType.equals("CreditCard")) {
            // Process credit card payment
            System.out.println("Processing credit card payment of $" + amount);
        } else if (paymentType.equals("DebitCard")) {
            // Process debit card payment
            System.out.println("Processing debit card payment of $" + amount);
        } else if (paymentType.equals("PayPal")) {
            // Process PayPal payment
            System.out.println("Processing PayPal payment of $" + amount);
        } else {
            // Handle unsupported payment type
            System.out.println("Unsupported payment type: " + paymentType);
        }
    }

    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        paymentProcessor.processPayment("CreditCard", 100.0);
        paymentProcessor.processPayment("DebitCard", 50.0);
        paymentProcessor.processPayment("PayPal", 75.0);
        paymentProcessor.processPayment("Bitcoin", 200.0);
    }
}
