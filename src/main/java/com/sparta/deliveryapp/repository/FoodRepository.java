package com.sparta.deliveryapp.repository;


import com.sparta.deliveryapp.model.Food;
import com.sparta.deliveryapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Long> {
    List<Food> findAllByRestaurant(Restaurant restaurant);
    boolean existsByRestaurantAndName(Restaurant restaurant,String Name);

}
