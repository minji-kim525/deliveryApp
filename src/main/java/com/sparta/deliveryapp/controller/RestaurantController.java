package com.sparta.deliveryapp.controller;

import com.sparta.deliveryapp.dto.RestaurantRequestDto;
import com.sparta.deliveryapp.model.Restaurant;
import com.sparta.deliveryapp.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant(@RequestBody RestaurantRequestDto requestDto ){
        return restaurantService.registerRestaurant(requestDto);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurant(){
        return restaurantService.getAllRestaurant();
    }
}

