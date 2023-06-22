package com.gen.restaurantapp.model.dto;

import com.gen.restaurantapp.model.User;
import lombok.Data;

@Data
public class PlainUserDTO
{
   private Long id;
   private String name;
   private String email;

   public static PlainUserDTO from(User user)
   {
      PlainUserDTO plainUserDTO = new PlainUserDTO();
      plainUserDTO.setId(user.getId());
      plainUserDTO.setName(user.getName());
      plainUserDTO.setEmail(user.getEmail());
      return plainUserDTO;
   }
}
