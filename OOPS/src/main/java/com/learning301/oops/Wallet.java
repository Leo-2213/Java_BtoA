package com.learning301.oops;

public class Wallet implements PaymentMethds{

    private String walletId;

    public Wallet(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public void pay() {
        System.out.println("payment done using Wallet " + walletId);
    }
}
