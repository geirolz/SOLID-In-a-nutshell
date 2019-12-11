package com.github.geirolz.solid.ocp.solution.dynamicPolymorphism;

import java.math.BigDecimal;

public class ItemPriceMain {

    public static void main(String[] args) {
        BigDecimal jeansPrice = ItemPrice.calculate(new JeansPriceCalculator());
        BigDecimal shoesPrice = ItemPrice.calculate(new ShoesPriceCalculator());

        System.out.println("Jeans Price is: " + jeansPrice + "€");
        System.out.println("Shoes Price is: " + shoesPrice + "€");
    }
}
