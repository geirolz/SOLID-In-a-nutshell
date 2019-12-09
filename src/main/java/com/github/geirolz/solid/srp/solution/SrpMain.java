package com.github.geirolz.solid.srp.solution;

import java.math.BigDecimal;

public class SrpMain {
    private static final ShippingService shippingService = new ShippingServiceImpl();
    private static final ShippingManager shippingManager = new ShippingManager(shippingService);
    private static final Order order1 = sample1();
    private static final Order order2 = sample2();

    public static void main(String[] args) {
        System.out.println(OrderPrinter.printOrder(order1));
        System.out.println(OrderPrinter.printOrder(order2));

        System.out.println(shippingManager.shipOrder(order1));
        System.out.println(shippingManager.shipOrder(order2));
    }

    private static class ShippingServiceImpl implements ShippingService {
        public OrderStatus ship(Order order) {
            System.out.println("Shipped " + order.getOrderId());
            return OrderStatus.SHIPPED;
        }
    }

    private static Order sample1() {
        return new Order("order1",
                "Andrea",
                "Via ... 1",
                "Rossi",
                "IT",
                new BigDecimal(100),
                OrderStatus.CREATED);
    }

    private static Order sample2() {
        return new Order("order2",
                "Luca",
                "Via ... 5",
                "Bianchi",
                "UK",
                new BigDecimal(130),
                OrderStatus.CANCELLED);
    }
}
