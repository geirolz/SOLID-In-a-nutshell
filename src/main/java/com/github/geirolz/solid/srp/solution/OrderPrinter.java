package com.github.geirolz.solid.srp.solution;

public class OrderPrinter {
    public static String printOrder(Order order) {
        final StringBuffer res = new StringBuffer();
        res.append("----- ORDER NO: ").append(order.getOrderId()).append("\n");
        res.append("----- SHIPPED TO ").append(order.getCustomerLastName()).append(" ").append(order.getCustomerFirstName()).append("\n");
        res.append("----- IN ").append(order.getShipToAddress()).append(" - ").append(order.getShipToCountry()).append("\n");
        res.append("Tot. Amount: ").append(order.getTotalAmount()).append(" ").append(selectCurrency(order)).append("\n\n\n");

        return res.toString();
    }

    private static String selectCurrency(Order order) {
        final String orderCountry = order.getShipToCountry();
        if("UK".equals(orderCountry))
            return "£";

        if("US".equals(orderCountry))
            return "$";

        return "€";
    }
}
