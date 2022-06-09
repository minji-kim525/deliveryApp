package com.sparta.deliveryapp.model;

import com.sparta.deliveryapp.exeption.OrderException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@RequiredArgsConstructor
@Getter
@Entity
public class OrderFood {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    public OrderFood(String name, int quantity, int price) {

        OrderException.OrderValid(quantity);

        this.name = name;
        this.quantity = quantity;
        this.price = price * quantity;
    }

}
