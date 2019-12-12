package com.github.geirolz.solid.srp.exercise;

public class ShippingManager {
    private final ShippingService shippingService;

    public ShippingManager(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public OrderStatus shipOrder(Order order) {
        final OrderStatus orderStatus = order.getStatus();

        if(OrderStatus.CREATED == orderStatus)
            return shippingService.ship(order);

        return orderStatus;
    }
}
