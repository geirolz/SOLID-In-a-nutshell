package com.github.geirolz.solid.srp.exercise;

import java.math.BigDecimal;

public class Order {
    private final String orderId;
    private final String customerFirstName;
    private final String shipToAddress;
    private final String customerLastName;
    private final String shipToCountry;
    private final BigDecimal totalAmount;
    private final OrderStatus status;
    private final ShippingService shippingService;

    public Order(String orderId,
                 String customerFirstName,
                 String shipToAddress,
                 String customerLastName,
                 String shipToCountry,
                 BigDecimal totalAmount,
                 OrderStatus status,
                 ShippingService shippingService) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.customerFirstName = customerFirstName;
        this.shipToAddress = shipToAddress;
        this.customerLastName = customerLastName;
        this.shipToCountry = shipToCountry;
        this.status = status;
        this.shippingService = shippingService;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getShipToAddress() {
        return shipToAddress;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getShipToCountry() {
        return shipToCountry;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public OrderStatus shipOrder() {
        if(OrderStatus.CREATED == status)
            return shippingService.ship(this);

        return status;
    }

    public String printOrder() {
        final StringBuffer res = new StringBuffer();
        res.append("----- ORDER NO: ").append(getOrderId()).append("\n");
        res.append("----- SHIPPED TO ").append(getCustomerLastName()).append(" ").append(getCustomerFirstName()).append("\n");
        res.append("----- IN ").append(getShipToAddress()).append(" - ").append(getShipToCountry()).append("\n");
        res.append("Tot. Amount: ").append(getTotalAmount()).append(" ").append(selectCurrency()).append("\n\n\n");

        return res.toString();
    }

    private String selectCurrency() {
        if("UK".equals(shipToCountry))
            return "£";

        if("US".equals(shipToCountry))
            return "$";

        return "€";
    }
}
