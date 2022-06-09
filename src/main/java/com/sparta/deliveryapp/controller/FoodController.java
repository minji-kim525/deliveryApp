package com.sparta.deliveryapp.controller;

import com.sparta.deliveryapp.dto.FoodDto;
import com.sparta.deliveryapp.dto.FoodResponseDto;
import com.sparta.deliveryapp.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {

    private final FoodService foodService;

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodRequestDto){
        foodService.registerFood(restaurantId,foodRequestDto);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodResponseDto> getFood(@PathVariable Long restaurantId){
        return foodService.getFood(restaurantId);
    }
}
