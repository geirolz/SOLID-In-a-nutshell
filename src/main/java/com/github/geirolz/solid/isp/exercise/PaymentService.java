package com.github.geirolz.solid.isp.exercise;

public interface PaymentService {
    void virtualPay(Double value);
    void cardPay(Double value);
}
