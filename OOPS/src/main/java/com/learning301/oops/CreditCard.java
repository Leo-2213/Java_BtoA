package com.learning301.oops;

public class CreditCard extends Card{
    public CreditCard(String name, String cardNo) {
        super(name, cardNo);
    }

    @Override
    public void pay() {
        System.out.println("payment done by credit card " + cardNo);
    }
}
