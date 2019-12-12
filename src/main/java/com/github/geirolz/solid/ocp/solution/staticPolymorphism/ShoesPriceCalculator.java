package com.github.geirolz.solid.ocp.solution.staticPolymorphism;

import java.math.BigDecimal;

public class ShoesPriceCalculator implements ItemPriceCalculator {
    public BigDecimal computePrice() {
        return new BigDecimal(100);
    }
}