package com.learning301.Solid.ISP.BadCode;

public class Main {
    public static void main(String[] args) {
        Machine mac1 =  new SimplePrinter();
        Machine mac2 = new AllPurposeMachine();

        mac2.print();
        mac2.scan();

        mac1.print();
        mac1.scan();
    }
}
