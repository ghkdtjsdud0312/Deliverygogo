package com.deliverygogo.JDBC1.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO {
    private String CATEGORY_INFO;
    private int STORE_NUM;
    private String MENU_NAME;
    private int PRICE;
}
