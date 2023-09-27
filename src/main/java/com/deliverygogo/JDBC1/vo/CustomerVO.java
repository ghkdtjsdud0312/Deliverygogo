package com.deliverygogo.JDBC1.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVO {
    private String USER_ID;
    private String USER_PW;
    private String USER_NAME;
    private String GENDER;
    private String PHONE;
    private String ADDR;
    private String BIRTH;
    private String EMAIL;
    private String MONTHFEE;
}
