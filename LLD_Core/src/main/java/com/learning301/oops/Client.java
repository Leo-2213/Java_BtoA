package com.learning301.oops;

public class Client {
    public static void main(String[] args) {
        PaymentService ps = new PaymentService();

        ps.addPaymentMethods("Abhijeet1",new UPI("abhijeet007"));
        ps.addPaymentMethods("Abhijeet2",new DebitCard("Abhi","12345"));
        ps.addPaymentMethods("Abhijeet3", new CreditCard("Abhi", "67890"));
        ps.addPaymentMethods("Abhijeet4", new Wallet("123456789"));

        ps.makePayment("Abhijeet1");
        ps.makePayment("Abhijeet2");
        ps.makePayment("Abhijeet3");
          ps.makePayment("Abhijeet4");
    }
}
