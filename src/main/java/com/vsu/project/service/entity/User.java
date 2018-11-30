package com.vsu.project.service.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

public class User {

    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private long studentBookId;

    @Getter
    @Setter
    private long departmentId;

    @Getter
    @Setter
    private String userName;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private long rating;

    @Getter
    @Setter
    private Timestamp birthday;

    @Getter
    @Setter
    private String picture;
}
