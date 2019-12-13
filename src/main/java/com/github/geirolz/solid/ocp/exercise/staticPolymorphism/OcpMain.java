package com.github.geirolz.solid.ocp.exercise.staticPolymorphism;


import java.math.BigDecimal;

public class OcpMain {

    public static void main(String[] args) {

        ItemPrice<JeansPriceCalculator> jeansPriceCalculator = new ItemPrice<JeansPriceCalculator>(new JeansPriceCalculator());
        ItemPrice<ShoesPriceCalculator> shoesPriceCalculator = new ItemPrice<ShoesPriceCalculator>(new ShoesPriceCalculator());
        ItemPrice<TShirtPriceCalculator> tShirtPriceCalculator = new ItemPrice<TShirtPriceCalculator>(new TShirtPriceCalculator());
        BigDecimal jeansPrice = jeansPriceCalculator.calculate();
        BigDecimal shoesPrice = shoesPriceCalculator.calculate();
        BigDecimal tShirtPrice = tShirtPriceCalculator.calculate();
        System.out.println("Jeans Price is: " + jeansPrice + "€");
        System.out.println("Shoes Price is: " + shoesPrice + "€");
        System.out.println("T-Shirt Price is: " + tShirtPrice + "€");
    }
}
