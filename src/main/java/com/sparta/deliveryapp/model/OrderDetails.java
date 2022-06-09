package com.sparta.deliveryapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderDetails {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String restaurantName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Food_Order")
    private List<OrderFood> foods;

    @Column
    private int deliveryFee;

    @Column
    private int totalPrice;

    public OrderDetails(Restaurant restaurant, List<OrderFood> foodOrderList, int totalPrice) {
        if(totalPrice < restaurant.getMinOrderPrice()) {
            throw new NullPointerException("최소 주문 가격을 지켜주세요.");
        }

        this.restaurantName = restaurant.getName();
        this.foods = foodOrderList;
        this.deliveryFee = restaurant.getDeliveryFee();
        this.totalPrice = totalPrice + deliveryFee;
    }
}
