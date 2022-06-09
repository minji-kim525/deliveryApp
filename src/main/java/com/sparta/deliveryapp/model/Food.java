package com.sparta.deliveryapp.model;


import com.sparta.deliveryapp.dto.FoodDto;
import com.sparta.deliveryapp.exeption.FoodException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Food_ID")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name="RESTAURANT_ID",nullable = false)
    private Restaurant restaurant;

    public Food(String name, int price, Restaurant restaurant){
        this.name=name;
        this.price=price;
        this.restaurant=restaurant;
    }
    public Food(FoodDto foodDto, Restaurant restaurant){

        FoodException.FoodValid(foodDto);

        this.name= foodDto.getName();
        this.price= foodDto.getPrice();
        this.restaurant=restaurant;
    }


}
