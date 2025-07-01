package com.learning301.oops;

public class DebitCard extends Card{
    public DebitCard(String name, String cardNo) {
        super(name, cardNo);
    }

    @Override
    public void pay() {
        System.out.println("Payment done by debit card " + cardNo);
    }
}
