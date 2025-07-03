package com.learning301.Solid.ISP.GoodCode;

public class EpsonPrinter implements Printers{
    @Override
    public void print() {
        System.out.println("printing using Epson Printer");
    }
}
