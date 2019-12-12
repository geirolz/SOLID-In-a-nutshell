package com.github.geirolz.solid.ocp.exercise;

import java.math.BigDecimal;

class ItemPrice {

    static BigDecimal calculate(ItemPriceCalculator item) throws Exception {
        if (item instanceof ShoesPriceCalculator) {
            return ((ShoesPriceCalculator) item).getPriceForShoes();
        } else if(item instanceof JeansPriceCalculator){
            return ((JeansPriceCalculator) item).getPriceForJeans();
        } else throw new Exception("Unhandled ItemPriceCalculator!!!");
    }

    static class ShoesPriceCalculator extends ItemPriceCalculator {
        BigDecimal getPriceForShoes() {
            return new BigDecimal(100);
        }
    }

    static class JeansPriceCalculator extends ItemPriceCalculator {
        BigDecimal getPriceForJeans() {
            return new BigDecimal(10);
        }
    }

    static class ItemPriceCalculator {

    }
}
