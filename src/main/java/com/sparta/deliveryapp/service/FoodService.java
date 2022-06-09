package com.sparta.deliveryapp.service;

import com.sparta.deliveryapp.dto.FoodDto;
import com.sparta.deliveryapp.dto.FoodResponseDto;
import com.sparta.deliveryapp.model.Food;
import com.sparta.deliveryapp.model.Restaurant;
import com.sparta.deliveryapp.repository.FoodRepository;
import com.sparta.deliveryapp.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public List<Food> registerFood(Long restaurantId, List<FoodDto> foodRequest) {

        Restaurant restaurant= restaurantRepository.findById(restaurantId).orElseThrow(
                ()->new NullPointerException("음식점을 찾을 수 없습니다.")
        );
//        List <String> names=foodListDto.getFoodListDto().stream().map(FoodDto::getName).collect(toList());
        List<Food>foodList=new ArrayList<>();

        for(FoodDto foodNamePrice:foodRequest) {
            Food food = new Food(foodNamePrice,restaurant);

            if(foodRepository.existsByRestaurantAndName(restaurant,food.getName())){
                throw new NullPointerException("같은 이름의 음식이 이미 존재합니다.");
            }

            //입력된 음식명에 중복 에러
            if(foodList.stream().anyMatch(o->o.getName().equals(food.getName()))){
                throw new NullPointerException("같은 이름의 음식이 이미 존재합니다.");
            }

            foodList.add(food);
        }
        return foodRepository.saveAll(foodList);
    }

    public List<FoodResponseDto> getFood(Long restaurantId) {
        Restaurant restaurant=restaurantRepository.findById(restaurantId).orElseThrow(
                ()->new NullPointerException(("음식점을 찾을 수 없습니다."))
        );
        return foodRepository.findAllByRestaurant(restaurant).stream().map(FoodResponseDto::new).collect(Collectors.toList());

    }
}

