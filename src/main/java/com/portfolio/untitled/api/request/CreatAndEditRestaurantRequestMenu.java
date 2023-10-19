package com.portfolio.untitled.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreatAndEditRestaurantRequestMenu {
    private final String name;
    private final Integer price;
}
