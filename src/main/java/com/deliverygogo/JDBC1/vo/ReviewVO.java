package com.deliverygogo.JDBC1.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewVO {
    int REVIEW_NUM;
    int STORE_NUM;
    String MENU_NAME;
    String USER_ID;
    String SCORE;
    String WRITE_REVIEW;

}
