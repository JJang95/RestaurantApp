package com.gen.restaurantapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
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
           mappedBy = "user",
           cascade = CascadeType.ALL,
           orphanRemoval = true
   )
   private List<Restaurant> plates = new ArrayList<>();

   public void addPlate(Restaurant plate)
   {
      plates.add(plate);
   }
   public void removePlate(Restaurant plate)
   {
      plates.remove(plate);
   }

   public User()
   {
   }

   public User(Long id, String name, String description, String image, String address, String phone, String foodSafetyDoc, String email, String password)
   {
      this.id = id;
      this.name = name;
      this.description = description;
      this.image = image;
      this.address = address;
      this.phone = phone;
      this.foodSafetyDoc = foodSafetyDoc;
      this.email = email;
      this.password = password;
   }

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public String getImage()
   {
      return image;
   }

   public void setImage(String image)
   {
      this.image = image;
   }

   public String getAddress()
   {
      return address;
   }

   public void setAddress(String address)
   {
      this.address = address;
   }

   public String getPhone()
   {
      return phone;
   }

   public void setPhone(String phone)
   {
      this.phone = phone;
   }

   public String getFoodSafetyDoc()
   {
      return foodSafetyDoc;
   }

   public void setFoodSafetyDoc(String foodSafetyDoc)
   {
      this.foodSafetyDoc = foodSafetyDoc;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public String getPassword()
   {
      return password;
   }

   public void setPassword(String password)
   {
      this.password = password;
   }

   @Override
   public String toString()
   {
      return "User{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", description='" + description + '\'' +
              ", image='" + image + '\'' +
              ", address='" + address + '\'' +
              ", phone='" + phone + '\'' +
              ", foodSafetyDoc='" + foodSafetyDoc + '\'' +
              ", email='" + email + '\'' +
              ", password='" + password + '\'' +
              ", plates=" + plates +
              '}';
   }

//private String createdAt; //TODO implement creation time
}
