package com.deliverygogo.JDBC1.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
    private int ORDER_NUM;
    private Date DATE_NUM;
    private int STORE_NUM;
    private String MENU_NAME;
    private int AMOUNT;
    private String DILIVERY_OPTION;
    private String PAYMENT_OPTION;
    private int TOTAL_PAYMENT;
    private int PRICE;
    private int TOTAL;
    private String CATEGORY_INFO;
    private int REVIEW_NUM;
    private String SCORE;
    private String WRITE_REVIEW;
    private String USER_ID;

    public OrderVO(int ORDER_NUM, int STORE_NUM, String MENU_NAME, int AMOUNT, String DILIVERY_OPTION, String PAYMENT_OPTION) {
        this.ORDER_NUM = ORDER_NUM;
        this.STORE_NUM = STORE_NUM;
        this.MENU_NAME = MENU_NAME;
        this.AMOUNT = AMOUNT;
        this.DILIVERY_OPTION = DILIVERY_OPTION;
        this.PAYMENT_OPTION = PAYMENT_OPTION;
    }



    public OrderVO(int ORDER_NUM, Date DATE_NUM, int STORE_NUM, String MENU_NAME, int AMOUNT, int PRICE, int TOTAL_PAYMENT) {
        this.ORDER_NUM = ORDER_NUM;
        this.DATE_NUM = DATE_NUM;
        this.STORE_NUM = STORE_NUM;
        this.MENU_NAME = MENU_NAME;
        this.AMOUNT = AMOUNT;
        this.TOTAL_PAYMENT = TOTAL_PAYMENT;
        this.PRICE = PRICE;
    }

    public OrderVO(String CATEGORY_INFO , int STORE_NUM,  String MENU_NAME, int TOTAL) {
        this.STORE_NUM = STORE_NUM;
        this.MENU_NAME = MENU_NAME;
        this.TOTAL = TOTAL;
        this.CATEGORY_INFO = CATEGORY_INFO;
    }

}


