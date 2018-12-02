package com.vsu.project.service.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "test")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//
//    @Column(name = "student_book_id")
//    private long studentBookId;
//
//    @Column(name = "department_id")
//    private long departmentId;

    @NotNull
    private String username;
//
//    @Column(name = "description")
//    private String description;

    @NotNull
    private String password;
//
//    @Column(name = "rating")
//    private long rating;
//
//    @Column(name = "birthday")
//    private Timestamp birthday;
//
//    @Column(name = "picture")
//    private String picture;
}
