package com.deliverygogo.JDBC1.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MasterVO {
    private int bizNum;
    private String masterPW;
    private String masterStore;
    private String masterName;
    private String StoreNum;
}
