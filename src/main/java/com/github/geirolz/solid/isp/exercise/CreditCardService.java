package com.github.geirolz.solid.isp.exercise;

public class CreditCardService implements CardPaymentService {

    public void cardPay(Double value) {
        System.out.println("Charging " + value + "€ on Credit Card.");
    }
}
