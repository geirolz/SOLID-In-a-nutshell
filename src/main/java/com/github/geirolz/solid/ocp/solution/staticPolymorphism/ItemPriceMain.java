package com.github.geirolz.solid.ocp.solution.staticPolymorphism;


import java.math.BigDecimal;

public class ItemPriceMain {

    public static void main(String[] args) {

        ItemPrice<JeansPriceCalculator> jeansPriceCalculator = new ItemPrice<JeansPriceCalculator>(new JeansPriceCalculator());
        ItemPrice<ShoesPriceCalculator> shoesPriceCalculator = new ItemPrice<ShoesPriceCalculator>(new ShoesPriceCalculator());
        BigDecimal jeansPrice = jeansPriceCalculator.calculate();
        BigDecimal shoesPrice = shoesPriceCalculator.calculate();
        System.out.println("Jeans Price is: " + jeansPrice + "€");
        System.out.println("Shoes Price is: " + shoesPrice + "€");
    }
}