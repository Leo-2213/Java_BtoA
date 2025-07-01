package com.learning301.oops;

public abstract class Card implements PaymentMethds{
    protected String name;
    protected String cardNo;

    public Card(String name, String cardNo)
    {
        this.name =  name;
        this.cardNo = cardNo;
    }
}
