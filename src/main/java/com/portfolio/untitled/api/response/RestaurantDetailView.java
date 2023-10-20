package com.portfolio.untitled.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.awt.*;
import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantDetailView {
    private final Long id;
    private final String name;
    private final String address;
    private final ZonedDateTime createAt;
    private final ZonedDateTime updateAt;
    private final List<Manu> menus;


    @Getter
    @Builder
    @AllArgsConstructor
    public static class Manu{
        private final Long id;
        private final String name;
        private final Integer price;
        private final ZonedDateTime createAt;
        private final ZonedDateTime updateAt;

    }
}