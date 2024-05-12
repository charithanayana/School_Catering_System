package com.cn.catering.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MenuItemDto {

    private String name;
    private String description;
    private String nutrition;
    private double price;
    private int menuId;

}
