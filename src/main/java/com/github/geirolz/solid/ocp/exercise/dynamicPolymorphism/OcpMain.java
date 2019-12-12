package com.github.geirolz.solid.ocp.exercise.dynamicPolymorphism;

import java.math.BigDecimal;

public class OcpMain {

    public static void main(String[] args) {
        BigDecimal jeansPrice = ItemPrice.calculate(new ShoesPriceCalculator());
        BigDecimal shoesPrice = ItemPrice.calculate(new JeansPriceCalculator());

        System.out.println("Jeans Price is: " + jeansPrice + "€");
        System.out.println("Shoes Price is: " + shoesPrice + "€");
    }
}