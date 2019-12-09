package com.github.geirolz.solid.srp;

import java.math.BigDecimal;

public class SrpMain {
    private static final ShippingService shippingService = new ShippingServiceImpl();
    private static final Order order1 = sample1(shippingService);
    private static final Order order2 = sample2(shippingService);

    public static void main(String[] args) {
        System.out.println(order1.printOrder());
        System.out.println(order2.printOrder());

        System.out.println(order1.shipOrder());
        System.out.println(order2.shipOrder());
    }

    private static class ShippingServiceImpl implements ShippingService {
        public OrderStatus ship(Order order) {
            System.out.println("Shipped " + order.getOrderId());
            return OrderStatus.SHIPPED;
        }
    }

    private static Order sample1(ShippingService shippingService) {
        return new Order("order1",
                "Andrea",
                "Via ... 1",
                "Rossi",
                "IT",
                new BigDecimal(100),
                OrderStatus.CREATED,
                shippingService);
    }

    private static Order sample2(ShippingService shippingService) {
        return new Order("order2",
                "Luca",
                "Via ... 5",
                "Bianchi",
                "UK",
                new BigDecimal(130),
                OrderStatus.CANCELLED,
                shippingService);
    }
}
