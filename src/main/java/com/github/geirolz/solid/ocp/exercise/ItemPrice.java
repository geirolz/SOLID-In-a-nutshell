package com.github.geirolz.solid.ocp.exercise;

import java.math.BigDecimal;

class ItemPrice {

    public BigDecimal calculate(ItemPriceCalculator item) throws Exception {
        if (item instanceof ShoesPriceCalculator) {
            return ((ShoesPriceCalculator) item).getPriceForShoes();
        } else if(item instanceof JeansPriceCalculator){
            return ((JeansPriceCalculator) item).getPriceForJeans();
        } else throw new Exception("Unhandled ItemPriceCalculator!!!");
    }

    class ShoesPriceCalculator extends ItemPriceCalculator {
        BigDecimal getPriceForShoes() {
            return new BigDecimal(100);
        }
    }

    class JeansPriceCalculator extends ItemPriceCalculator {
        BigDecimal getPriceForJeans() {
            return new BigDecimal(10);
        }
    }

    class ItemPriceCalculator {

    }


}
