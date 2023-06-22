package com.gen.restaurantapp.model.dto;

import com.gen.restaurantapp.model.Restaurant;
import com.gen.restaurantapp.model.User;
import lombok.Data;

import java.util.Objects;

@Data
public class RestaurantDTO
{
   private Long id;
   private String name;
   private String type;
   private Long price;
   private String description;
   private String image;
   private PlainUserDTO plainUserDTO;

   public static RestaurantDTO from(Restaurant plate)
   {
      RestaurantDTO plateDTO = new RestaurantDTO();
      plateDTO.setId(plate.getId());
      plateDTO.setName(plate.getName());
      plateDTO.setType(plate.getType());
      plateDTO.setPrice(plate.getPrice());
      plateDTO.setDescription(plate.getDescription());
      plateDTO.setImage(plate.getImage());
      if (Objects.nonNull(plate.getUser()))
      {
         plateDTO.setPlainUserDTO(PlainUserDTO.from(plate.getUser()));
      }
      return plateDTO;
   }
}
