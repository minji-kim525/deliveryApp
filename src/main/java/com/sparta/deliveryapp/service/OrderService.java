package com.sparta.deliveryapp.service;

import com.sparta.deliveryapp.dto.FoodResponseDto;
import com.sparta.deliveryapp.dto.OrderDetailsRequestDto;
import com.sparta.deliveryapp.dto.OrderRequestDto;
import com.sparta.deliveryapp.model.Food;
import com.sparta.deliveryapp.model.OrderDetails;
import com.sparta.deliveryapp.model.OrderFood;
import com.sparta.deliveryapp.model.Restaurant;
import com.sparta.deliveryapp.repository.FoodRepository;
import com.sparta.deliveryapp.repository.OrderRepository;
import com.sparta.deliveryapp.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;

    public OrderDetails createOrder(OrderRequestDto orderRequestDto) {

        Long restaurantId=orderRequestDto.getRestaurantId();
        Restaurant restaurant=restaurantRepository.findById(restaurantId).orElseThrow(
                ()->new NullPointerException("음식점을 찾을 수 없습니다.")
        );
        List<OrderFood>orderFoodList=new ArrayList<>();
        int totalPrice=0;
        for(OrderDetailsRequestDto orderDetailsRequestDto: orderRequestDto.getFoods()){
            Food food=foodRepository.findById(orderDetailsRequestDto.getId()).orElseThrow(
                    ()->new NullPointerException("음식을 찾을 수 없습니다.")
            );
        OrderFood orderFood= new OrderFood(food.getName(),orderDetailsRequestDto.getQuantity(),food.getPrice());
        totalPrice+=food.getPrice()*orderDetailsRequestDto.getQuantity();
        orderFoodList.add(orderFood);
        }
        OrderDetails orderDetails=new OrderDetails(restaurant,orderFoodList,totalPrice);
        orderRepository.save(orderDetails);
        return orderDetails;
    }

    public OrderDetails[] getAllOrders(){
        List<OrderDetails> orderDetails=orderRepository.findAll();
        int arraySize=orderDetails.size();
//        return orderRepository.findAll().stream().map(OrderDetails::new).collect(Collectors.toList());
        return orderDetails.toArray(new OrderDetails[arraySize]);
    }
}
