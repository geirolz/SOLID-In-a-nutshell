package com.github.geirolz.solid.ocp.exercise.dynamicPolymorphism;

import java.math.BigDecimal;

class ItemPrice {

    static BigDecimal calculate(ItemPriceCalculator itemPriceCalculator) {
        return itemPriceCalculator.computePrice();
    }
}
