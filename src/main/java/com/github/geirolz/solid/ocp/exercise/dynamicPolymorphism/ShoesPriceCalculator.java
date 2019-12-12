package com.github.geirolz.solid.ocp.exercise.dynamicPolymorphism;

import java.math.BigDecimal;

public class ShoesPriceCalculator implements ItemPriceCalculator {
    public BigDecimal computePrice() {
        return new BigDecimal(100);
    }
}
