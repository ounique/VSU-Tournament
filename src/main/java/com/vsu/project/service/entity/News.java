package com.vsu.project.service.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner", nullable = false)
    private User user;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    @Column(name = "date_created")
    private Timestamp dateCreated;
}
