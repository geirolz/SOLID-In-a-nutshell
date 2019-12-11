package com.github.geirolz.solid.ocp.solution;

import java.math.BigDecimal;

public class JeansPriceCalculator implements ItemPriceCalculator {
    public BigDecimal calculatePrice() {
        return new BigDecimal(10);
    }
}
