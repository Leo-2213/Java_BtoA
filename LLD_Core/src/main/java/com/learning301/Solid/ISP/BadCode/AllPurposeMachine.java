package com.learning301.Solid.ISP.BadCode;

public class AllPurposeMachine implements Machine{

    @Override
    public void print() {
        System.out.println(" printing document");
    }

    @Override
    public void scan() {
        System.out.println("scaning document");
    }
}
