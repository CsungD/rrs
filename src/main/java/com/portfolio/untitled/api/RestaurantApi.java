package com.portfolio.untitled.api;

import com.portfolio.untitled.api.request.CreateAndEditRestaurant;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantApi {

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
    public String createRestaurant(
            @RequestBody CreateAndEditRestaurant request
            ) {
        return "This is createRestaurant, name = " + request.getName() +" address = " + request.getAddress() +
                " menu[0].name = " +request.getMenus().get(0).getName() + " menu[0].price = " + request.getMenus().get(0).getPrice();
    }

    @PutMapping("/restaurant/{restaurantId}")
    public String editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurant request
    ){
        return "This is editRestaurant" + restaurantId + "name = " + request.getName() +" address = " + request.getAddress() ;
    }

    @DeleteMapping("/restaurnant/{restaurantId}")
        public String deleteRestaurant(
                @PathVariable Long restaurantId
        ){
            return "This is DeleteRestaurant" + restaurantId;
        }
}

