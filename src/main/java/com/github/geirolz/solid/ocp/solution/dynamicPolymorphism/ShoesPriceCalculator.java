package com.github.geirolz.solid.ocp.solution.dynamicPolymorphism;

import java.math.BigDecimal;

public class ShoesPriceCalculator implements ItemPriceCalculator {
    public BigDecimal computePrice() {
        return new BigDecimal(100);
    }
}
