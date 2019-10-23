package com.test.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String passwd;
    private String sex;
    private String introduction;
    private String depatment;
    private String imgurl;
}