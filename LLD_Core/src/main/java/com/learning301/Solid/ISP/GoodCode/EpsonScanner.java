package com.learning301.Solid.ISP.GoodCode;

import org.springframework.beans.factory.annotation.Autowired;

public class EpsonScanner implements Scanners{
    @Override
    public void scan() {
        System.out.println("Scanning using Epson Scanner");
    }
}
