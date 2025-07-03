package com.learning301.Solid.ISP.GoodCode;

public class MultiPurposeMachine implements Printers, Scanners{
    @Override
    public void print() {
        System.out.println("printing using MultiPurposeMachine");
    }

    @Override
    public void scan() {
        System.out.println("scanning using MultiPurposeMachine");
    }
}
