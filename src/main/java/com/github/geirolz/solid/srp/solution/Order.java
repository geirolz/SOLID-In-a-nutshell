package com.github.geirolz.solid.srp.solution;

import java.math.BigDecimal;

public class Order {
    private final String orderId;
    private final String customerFirstName;
    private final String shipToAddress;
    private final String customerLastName;
    private final String shipToCountry;
    private final BigDecimal totalAmount;
    private final OrderStatus status;

    public Order(String orderId,
                 String customerFirstName,
                 String shipToAddress,
                 String customerLastName,
                 String shipToCountry,
                 BigDecimal totalAmount,
                 OrderStatus status) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.customerFirstName = customerFirstName;
        this.shipToAddress = shipToAddress;
        this.customerLastName = customerLastName;
        this.shipToCountry = shipToCountry;
        this.status = status;
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
}
