package com.qf.travel.entity;

import lombok.Data;

@Data
public class User {
    private Integer uid;

    private String username;

    private String password;

    private Integer idDelete;
}