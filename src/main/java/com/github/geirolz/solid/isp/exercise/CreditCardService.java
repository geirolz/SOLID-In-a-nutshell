package com.github.geirolz.solid.isp.exercise;

public class CreditCardService implements PaymentService {

    public void virtualPay(Double value) {
        throw new RuntimeException("This service only supports Credit Card.");
    }

    public void cardPay(Double value) {
        System.out.println("Charging " + value + "€ on Credit Card.");
    }
}
