package com.sparta.deliveryapp.dto;

import com.sparta.deliveryapp.model.OrderDetails;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequestDto {

    private Long restaurantId;
    private List<OrderDetailsRequestDto>foods;
}
