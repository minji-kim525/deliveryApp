package com.sparta.deliveryapp.exeption;

import com.sparta.deliveryapp.dto.RestaurantRequestDto;

public class RestaurantException {
    public static void RestaurantValid(RestaurantRequestDto restaurantRequestDto) {
        if (1000>restaurantRequestDto.getMinOrderPrice()||restaurantRequestDto.getMinOrderPrice()>100000){
            throw new NullPointerException("최소 주문 가격은 1,000원~100,000원 입니다.");
        }
        if (restaurantRequestDto.getMinOrderPrice()%100!=0){
            throw new NullPointerException("100원 단위로만 입력 가능합니다.");
        }
        if (restaurantRequestDto.getDeliveryFee()<0||restaurantRequestDto.getDeliveryFee()>10000){
            throw new NullPointerException("기본 배달비는 0원~10,000원 입니다.");
        }
        if (restaurantRequestDto.getDeliveryFee()%500!=0){
            throw new NullPointerException("500원 단위로만 입력 가능합니다.");
        }


    }
}
