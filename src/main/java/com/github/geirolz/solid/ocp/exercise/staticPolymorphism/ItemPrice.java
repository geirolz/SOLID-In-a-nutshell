package com.github.geirolz.solid.ocp.exercise.staticPolymorphism;

import java.math.BigDecimal;

class ItemPrice<GenericItemPriceCalculator extends ItemPriceCalculator> {

    private final GenericItemPriceCalculator genericItemPriceCalculator;

    BigDecimal calculate() {
        return genericItemPriceCalculator.computePrice();
    }

    ItemPrice(GenericItemPriceCalculator genericItemPriceCalculator) {
        this.genericItemPriceCalculator = genericItemPriceCalculator;
    }
}
