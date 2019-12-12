package com.github.geirolz.solid.ocp.exercise;

import java.math.BigDecimal;

public class OcpMain {

    public static void main(String[] args) throws Exception {

        BigDecimal jeansPrice = ItemPrice.calculate(new ItemPrice.JeansPriceCalculator());
        BigDecimal shoesPrice = ItemPrice.calculate(new ItemPrice.ShoesPriceCalculator());

        System.out.println("Jeans Price is: " + jeansPrice + "€");
        System.out.println("Shoes Price is: " + shoesPrice + "€");
    }
}
