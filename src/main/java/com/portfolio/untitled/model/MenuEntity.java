package com.portfolio.untitled.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor //생성자 (매개변수 o)
@NoArgsConstructor //생성자 (매개변수 x)
@Table(name = "menu")
@Entity
public class MenuEntity {
    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //설정된 기본키 자동증가 (새로생성마다)
    private Long id;

    private Long restaurantId;
    private String name;
    private Integer price;
    private ZonedDateTime createAt;
    private ZonedDateTime updateAt;
}
