package com.gen.restaurantapp.model.dto;

import com.gen.restaurantapp.model.Restaurant;
import com.gen.restaurantapp.model.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDTO
{
   private Long id;
   private String name;
   private String description;
   private String image;
   private String address;
   private String phone;
   private String foodSafetyDoc;
   private String email;
   private String password;
   private List<RestaurantDTO> platesDTO = new ArrayList<>();

   public static UserDTO from(User user)
   {
      UserDTO userDTO = new UserDTO();
      userDTO.setId(user.getId());
      userDTO.setName(user.getName());
      userDTO.setDescription(user.getDescription());
      userDTO.setImage(user.getImage());
      userDTO.setAddress(user.getAddress());
      userDTO.setPhone(user.getPhone());
      userDTO.setFoodSafetyDoc(user.getFoodSafetyDoc());
      userDTO.setEmail(user.getEmail());
      userDTO.setPassword(user.getPassword());
      userDTO.setPlatesDTO(user.getPlates().stream().map(RestaurantDTO::from).collect(Collectors.toList()));
      return userDTO;
   }
}
