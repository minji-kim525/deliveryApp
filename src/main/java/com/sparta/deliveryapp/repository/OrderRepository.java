package com.sparta.deliveryapp.repository;

import com.sparta.deliveryapp.model.OrderDetails;
import com.sparta.deliveryapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderDetails,Long> {

//    List<OrderDetails>findAllByRestaurant(Restaurant restaurant);
}
