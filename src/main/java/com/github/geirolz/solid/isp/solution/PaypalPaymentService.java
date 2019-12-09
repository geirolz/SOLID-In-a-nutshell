package com.github.geirolz.solid.isp.solution;

public class PaypalPaymentService implements VirtualPaymentService {
    public void virtualPay(Double value) {
        System.out.println("Charging " + value + "€ on Paypal.");
    }
}
