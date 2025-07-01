package com.learning301.oops;

import java.util.HashMap;

public class PaymentService {
    HashMap<String, PaymentMethds> paymentMethds;

    PaymentService()
    {
        paymentMethds = new HashMap<>();
    }

    public void addPaymentMethods(String name, PaymentMethds pm){
        paymentMethds.put(name, pm);
    }

    public void makePayment(String name)
    {
        paymentMethds.get(name).pay(); //Run time Polymorphism
    }

}
