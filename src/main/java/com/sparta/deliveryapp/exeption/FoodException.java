package com.sparta.deliveryapp.exeption;

import com.sparta.deliveryapp.dto.FoodDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FoodException {
    public static void FoodValid(FoodDto foodDto) {

        if (foodDto.getPrice() < 100 || foodDto.getPrice() > 1000000) {
            throw new NullPointerException("음식 가격은 100원 ~ 1,000,000원 입니다.");
        }
        if (foodDto.getPrice() % 100 != 0) {
            throw new NullPointerException("100원 단위로만 입력 가능합니다.");
        }
//        assert foodRepository != null;
//        Food food=foodRepository.findByRestaurant(restaurant);
//        if(food.getName()==foodDto.getName()){
//            throw new NullPointerException("같은 음식 이름을 사용할 수 없습니다.");
//        }
    }
}