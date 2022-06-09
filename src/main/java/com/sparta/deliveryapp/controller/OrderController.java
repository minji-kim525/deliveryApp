package com.sparta.deliveryapp.controller;

import com.sparta.deliveryapp.dto.OrderRequestDto;
import com.sparta.deliveryapp.model.OrderDetails;
import com.sparta.deliveryapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order/request")
    public OrderDetails createOrder(@RequestBody OrderRequestDto orderRequestDto){

        return orderService.createOrder(orderRequestDto);
    }

    @GetMapping("/orders")
    public OrderDetails[] getAllOrders(){
        return orderService.getAllOrders();
    }
}
