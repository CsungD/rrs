package com.portfolio.untitled.api;

import com.portfolio.untitled.api.request.CreateAndEditRestaurant;
import com.portfolio.untitled.model.RestaurantEntity;
import com.portfolio.untitled.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
public class RestaurantApi {
    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public String getRestaurants(){
        return "This is getRestaurants";

    }

    @GetMapping("/restaurant/{restaurantId}")
    public String getRestaurant(
            @PathVariable Long restaurantId
    ){
        return "This is getRestaurant, " + restaurantId;

    }

    @PostMapping("/restaurnant")
    public void createRestaurant(
            @RequestBody CreateAndEditRestaurant request
            ) {
        restaurantService.createRestaurant(request);
    }

    @PutMapping("/restaurant/{restaurantId}")
    public void editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurant request
    ){
        restaurantService.editRestaurant(restaurantId, request);
    }

    @DeleteMapping("/restaurnant/{restaurantId}")
        public void deleteRestaurant(
                @PathVariable Long restaurantId
        ){
           restaurantService.deleteRestaurant(restaurantId);
        }
}

