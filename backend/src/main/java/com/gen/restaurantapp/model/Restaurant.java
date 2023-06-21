package com.gen.restaurantapp.model;

import com.gen.restaurantapp.model.dto.RestaurantDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Restaurant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String type;
    private Long price;
    private String description;
    private String image;

    @ManyToOne
    private User user;

    public static Restaurant from(RestaurantDTO plateDTO)
    {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(plateDTO.getName());
        restaurant.setType(plateDTO.getType());
        restaurant.setPrice(plateDTO.getPrice());
        restaurant.setDescription(plateDTO.getDescription());
        restaurant.setImage(plateDTO.getImage());
        return restaurant;
    }

}
