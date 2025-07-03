package com.learning301.Solid.ISP.BadCode;

import com.learning301.Solid.LSP.GoodCode.Main;

public class SimplePrinter implements Machine {
    public void print() {
        System.out.println("Printing document");
    }

    @Override
    public void scan() {
        throw new RuntimeException("Not supported");
    }
}
