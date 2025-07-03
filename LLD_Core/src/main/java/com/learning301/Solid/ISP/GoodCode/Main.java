package com.learning301.Solid.ISP.GoodCode;

public class Main {
    public static void main(String[] args) {

        Printers printer = new EpsonPrinter();
        printer.print();

        Scanners scanner = new EpsonScanner();
        scanner.scan();

        MultiPurposeMachine multiPurposeMachine = new MultiPurposeMachine();
        multiPurposeMachine.print();
        multiPurposeMachine.scan();

    }
}
