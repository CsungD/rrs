package com.portfolio.untitled.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter @AllArgsConstructor
public class CreateAndEditRestaurant {
    private final String name;
    private final String address;
    private final List<CreatAndEditRestaurantRequestMenu> menus;
}
