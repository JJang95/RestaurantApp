package com.gen.restaurantapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gen.restaurantapp.model.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User implements Serializable
{


   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(nullable = false, updatable = false)
   private Long id;
   private String name;
   private String description;
   private String image;
   private String address;
   private String phone;
   private String foodSafetyDoc;
   private String email;
   private String password;


   @OneToMany(
           cascade = CascadeType.ALL
   )
   @JoinColumn(name = "user_id")
   private List<Restaurant> plates = new ArrayList<>();

   public static User from(UserDTO userDTO)
   {
      User user = new User();
      user.setName(userDTO.getName());
      user.setDescription(userDTO.getDescription());
      user.setImage(userDTO.getImage());
      user.setAddress(userDTO.getAddress());
      user.setPhone(userDTO.getPhone());
      user.setFoodSafetyDoc(userDTO.getFoodSafetyDoc());
      user.setEmail(userDTO.getEmail());
      user.setPassword(userDTO.getPassword());
      return user;
   }

   public void addPlate(Restaurant plate)
   {
      plates.add(plate);
   }
   public void removePlate(Restaurant plate)
   {
      plates.remove(plate);
   }


//private String createdAt; //TODO implement creation time
}
