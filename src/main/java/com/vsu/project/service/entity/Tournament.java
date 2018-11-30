package com.vsu.project.service.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

public class Tournament {

    @Getter @Setter private long id;

    @Getter
    @Setter
    private long departmentId;

    @Getter
    @Setter
    private long winnerId;


    @Getter
    @Setter
    private long giftId;

    @Getter
    @Setter
    private Timestamp startDate;

    @Getter
    @Setter
    private Timestamp endDate;

}
