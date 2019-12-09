package com.github.geirolz.solid.isp.exercise;

public class PaypalPaymentService implements PaymentService {

    public void virtualPay(Double value) {
        System.out.println("Charging " + value + "€ on Paypal.");
    }

    public void cardPay(Double value) {
        throw new RuntimeException("This service only supports Paypal.");
    }
}
