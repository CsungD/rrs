package com.portfolio.untitled.api;

import com.portfolio.untitled.api.request.CreateAndEditRestaurant;
import com.portfolio.untitled.api.response.RestaurantDetailView;
import com.portfolio.untitled.api.response.RestaurantView;
import com.portfolio.untitled.model.RestaurantEntity;
import com.portfolio.untitled.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantApi {
    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<RestaurantView> getRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/restaurant/{restaurantId}")
    public RestaurantDetailView getRestaurant(
            @PathVariable Long restaurantId
    ){
        return restaurantService.getRestaurantDetail(restaurantId);
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

