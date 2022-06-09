package com.sparta.deliveryapp.model;

import com.sparta.deliveryapp.dto.RestaurantRequestDto;
import com.sparta.deliveryapp.exeption.RestaurantException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Restaurant_ID")
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private int minOrderPrice;

    @Column(nullable = false)
    private int deliveryFee;

    public Restaurant( String name, int minOrderPrice,int deliveryFee){
        this.name=name;
        this.minOrderPrice=minOrderPrice;
        this.deliveryFee=deliveryFee;
    }
    public Restaurant(RestaurantRequestDto requestDto){
        RestaurantException.RestaurantValid(requestDto);

        this.name=requestDto.getName();
        this.minOrderPrice=requestDto.getMinOrderPrice();
        this.deliveryFee=requestDto.getDeliveryFee();
    }

}
