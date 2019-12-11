package com.github.geirolz.solid.ocp.solution.dynamic;

import java.math.BigDecimal;

public class ShoesPriceCalculator implements ItemPriceCalculator {
    public BigDecimal calculatePrice() {
        return new BigDecimal(100);
    }
}
