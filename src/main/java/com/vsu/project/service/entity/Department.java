package com.vsu.project.service.entity;

import com.vsu.project.service.entity.enums.UserRole;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;

    private String description;

    private String picture;

    @Column(name = "social_vk")
    private String linkVK;

    @Column(name = "social_fb")
    private String linkFB;

    @Column(name = "social_inst")
    private String linkINS;

    @Column(name = "social_twi")
    private String linkTWI;
}
