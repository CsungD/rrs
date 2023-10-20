package com.portfolio.untitled.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantView {
    private final Long id;
    private final String name;
    private final String address;
    private final ZonedDateTime createAt;
    private final ZonedDateTime updateAt;
}
