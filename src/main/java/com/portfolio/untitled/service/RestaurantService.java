package com.portfolio.untitled.service;

import com.portfolio.untitled.api.request.CreateAndEditRestaurant;
import com.portfolio.untitled.api.response.RestaurantDetailView;
import com.portfolio.untitled.api.response.RestaurantView;
import com.portfolio.untitled.model.MenuEntity;
import com.portfolio.untitled.model.RestaurantEntity;
import com.portfolio.untitled.repository.MenuRepository;
import com.portfolio.untitled.repository.RestauranRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestauranRepository restauranRepository;
    private final MenuRepository menuRepository;
    @Transactional //트랙잭션... 공부하자 슥슥
    public RestaurantEntity createRestaurant(
            CreateAndEditRestaurant request
    ){
        RestaurantEntity restaurant = RestaurantEntity.builder()//시작점
                .name(request.getName())
                .address(request.getAddress())
                .createAt(ZonedDateTime.now())
                .updateAt(ZonedDateTime.now())
                .build();//끝점

        restauranRepository.save(restaurant);

        request.getMenus().forEach( (menu) -> { //람다식
            MenuEntity menuEntity = MenuEntity.builder()
                    .restaurantId(restaurant.getId())
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .createAt(ZonedDateTime.now())
                    .updateAt(ZonedDateTime.now())
                    .build();

        menuRepository.save(menuEntity);
        });



        return restaurant;
    }

    @Transactional
    public void editRestaurant(
            Long restaurantId, //찾기위한 레스토랑아이디값
            CreateAndEditRestaurant request
    ){
        RestaurantEntity restaurant = restauranRepository.findById(restaurantId).orElseThrow( ()-> new RuntimeException("없는 레스토랑입니다."));
        restaurant.changeNameAndAddress(request.getName(), request.getAddress());
        restauranRepository.save(restaurant);

        List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
        menuRepository.deleteAll(menus);

        request.getMenus().forEach((menu) -> {
            MenuEntity menuEntity = MenuEntity.builder()
                    .restaurantId(restaurantId)
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .createAt(ZonedDateTime.now())
                    .updateAt(ZonedDateTime.now())
                    .build();

            menuRepository.save(menuEntity);
        }) ;
    }
    @Transactional
    public void deleteRestaurant(Long restaurantId){
        RestaurantEntity restaurant = restauranRepository.findById(restaurantId).orElseThrow();
        restauranRepository.delete(restaurant);

        List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
        menuRepository.deleteAll(menus);
    }

    public List<RestaurantView> getAllRestaurants(){
        List<RestaurantEntity> restaurants = restauranRepository.findAll(); //모든키의 값을 가져온다.  RestaurantEntity에서 확인해보자

        return restaurants.stream().map((restaurant) -> RestaurantView.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .createAt(restaurant.getCreateAt())
                .updateAt(restaurant.getUpdateAt())
                .build()
        ).toList();
    }

    public RestaurantDetailView getRestaurantDetail(Long restaurantId){
        RestaurantEntity restaurant = restauranRepository.findById(restaurantId).orElseThrow();
        List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);

        return RestaurantDetailView.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .createAt(restaurant.getCreateAt())
                .updateAt(restaurant.getUpdateAt())
                .menus(
                        menus.stream().map((menu) -> RestaurantDetailView.Manu.builder()
                                .id(menu.getId())
                                .name(menu.getName())
                                .price(menu.getPrice())
                                .createAt(menu.getCreateAt())
                                .updateAt(menu.getUpdateAt())
                                .build()
                        ).toList()
                ).build();
    }
}
