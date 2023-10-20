package com.portfolio.untitled.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@Builder //골라서 전송하는거같습니다 공부합시다
@AllArgsConstructor
@NoArgsConstructor //매개변수 없는 생성자
@Table(name="restaurant") //테이블 명
@Entity //
public class RestaurantEntity {
    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //설정된 기본키 자동증가 (새로생성마다)
    private Long id;

    private String name;
    private String address;
    private ZonedDateTime createAt;
    private ZonedDateTime updateAt;

    public void changeNameAndAddress(String name, String address){
        this.name = name;
        this.address = address;
        this.updateAt = ZonedDateTime.now();
    }
}
