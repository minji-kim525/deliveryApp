package com.sparta.deliveryapp.repository;

import com.sparta.deliveryapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

}