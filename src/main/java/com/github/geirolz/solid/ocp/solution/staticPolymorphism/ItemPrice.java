package com.github.geirolz.solid.ocp.solution.staticPolymorphism;

import java.math.BigDecimal;

class ItemPrice<GenericItemPriceCalculator extends ItemPriceCalculator> {

    private GenericItemPriceCalculator genericItemPriceCalculator;

    BigDecimal calculate() {
        return genericItemPriceCalculator.computePrice();
    }

    ItemPrice(GenericItemPriceCalculator genericItemPriceCalculator) {
        this.genericItemPriceCalculator = genericItemPriceCalculator;
    }
}
