package com.learning301.oops;

public class UPI implements PaymentMethds{
    private String upiId;

    public UPI(String upiId) {
        this.upiId = upiId;
    }
    public void pay(){
        System.out.println("Payment done by UPI " + upiId);
    }
}
