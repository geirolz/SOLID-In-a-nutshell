package com.github.geirolz.solid.ocp.exercise.staticPolymorphism;

import java.math.BigDecimal;

public class TShirtPriceCalculator implements ItemPriceCalculator {
    public BigDecimal computePrice() {
        return new BigDecimal(10);
    }
}
