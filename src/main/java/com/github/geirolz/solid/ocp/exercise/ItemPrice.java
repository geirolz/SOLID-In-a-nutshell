package com.github.geirolz.solid.ocp.exercise;

import java.math.BigDecimal;

class ItemPrice {

    enum ItemType {
        SHOES, JEANS
    }

    interface ItemPriceCalculator {
        ItemType getItemType();
    }

    static class ShoesPriceCalculator implements ItemPriceCalculator {
        BigDecimal getPriceForShoes() {
            return new BigDecimal(100);
        }

        public ItemType getItemType() {
            return ItemType.SHOES;
        }
    }

    static class JeansPriceCalculator implements ItemPriceCalculator {
        BigDecimal getPriceForJeans() {
            return new BigDecimal(10);
        }

        public ItemType getItemType() {
            return ItemType.JEANS;
        }
    }

    static BigDecimal calculate(ItemPriceCalculator calculator) throws Exception {
        if (calculator.getItemType() == ItemType.SHOES) {
            return ((ShoesPriceCalculator) calculator).getPriceForShoes();
        } else if (calculator.getItemType() == ItemType.JEANS) {
            return ((JeansPriceCalculator) calculator).getPriceForJeans();
        } else throw new Exception("Unhandled ItemPriceCalculator!!!");
    }
}
