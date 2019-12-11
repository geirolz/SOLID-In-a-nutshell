package com.github.geirolz.solid.ocp.solution;

import java.math.BigDecimal;

public class ItemPrice {

    public BigDecimal calculate(ItemPriceCalculator item) {
        return item.calculatePrice();
    }
}
