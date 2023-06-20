package com.gen.restaurantapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
public class Users {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long user_id;
    private String username;
    private String password;
    private String role;
    @CreationTimestamp
    private Date createdAt;
}
