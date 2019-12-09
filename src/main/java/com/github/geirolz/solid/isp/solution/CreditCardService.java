package com.github.geirolz.solid.isp.solution;

public class CreditCardService implements CardPaymentService {

    public void cardPay(Double value) {
        System.out.println("Charging " + value + "€ on Credit Card.");
    }
}
