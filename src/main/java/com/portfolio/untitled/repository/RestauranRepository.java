package com.portfolio.untitled.repository;

import com.portfolio.untitled.model.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//
public interface RestauranRepository extends JpaRepository<RestaurantEntity, Long> {
}
