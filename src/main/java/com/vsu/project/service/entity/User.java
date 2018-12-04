package com.vsu.project.service.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "student_book_id")
    @NotNull
    private long studentBookId;

    @Column(name = "department_id")
    @NotNull
    private long departmentId;

    @NotNull
    private String username;

    private String description;

    @NotNull
    private String password;

    @NotNull
    private long rating;

    @NotNull
    private Timestamp birthday;

    private String picture;
}
