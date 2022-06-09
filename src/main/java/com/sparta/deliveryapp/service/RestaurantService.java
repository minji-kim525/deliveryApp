package com.sparta.deliveryapp.service;

import com.sparta.deliveryapp.dto.RestaurantRequestDto;
import com.sparta.deliveryapp.model.Restaurant;
import com.sparta.deliveryapp.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;


    public Restaurant registerRestaurant(RestaurantRequestDto requestDto) {
        Restaurant restaurant= new Restaurant(requestDto);
        return restaurantRepository.save(restaurant);

    }

    public List<Restaurant> getAllRestaurant() {

        return restaurantRepository.findAll();
    }
}
