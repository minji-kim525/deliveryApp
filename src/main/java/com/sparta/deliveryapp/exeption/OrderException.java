package com.sparta.deliveryapp.exeption;

public class OrderException {

    public static void OrderValid(int quantity){
        if(quantity<1||quantity>100){
            throw new NullPointerException("주문 수량은 1 ~ 100 입니다.");

        }
    }
}
