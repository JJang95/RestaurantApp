package com.gen.restaurantapp.controller;

import com.gen.restaurantapp.model.Restaurant;
import com.gen.restaurantapp.model.User;
import com.gen.restaurantapp.model.dto.RestaurantDTO;
import com.gen.restaurantapp.model.dto.UserDTO;
import com.gen.restaurantapp.service.RestaurantService;
import com.gen.restaurantapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
   private final UserService userService;
   private final RestaurantService restaurantService;

   public UserController(UserService userService, RestaurantService restaurantService) {
      this.userService = userService;
      this.restaurantService = restaurantService;
   }

   @GetMapping("/all")
   public ResponseEntity<List<UserDTO>> getAllUsers() {
      List<User> restaurants = userService.findAllUsers();
      List<UserDTO> userDTOS = restaurants.stream().map(UserDTO::from).collect(Collectors.toList());
      return new ResponseEntity<>(userDTOS, HttpStatus.OK);
   }

   @GetMapping("/all/plates/{id}")
   public ResponseEntity<List<RestaurantDTO>> getAllPlates(@PathVariable("id") Long id) {
      List<Restaurant> plates = userService.findAllPlates(id);
      List<RestaurantDTO> restaurantDTOS = plates.stream().map(RestaurantDTO::from).collect(Collectors.toList());
      return new ResponseEntity<>(restaurantDTOS, HttpStatus.OK);
   }


   @GetMapping("/find/{id}")
   public ResponseEntity<UserDTO> getUserById (@PathVariable("id") Long id) {
      User user = userService.findUserById(id);
      return new ResponseEntity<>(UserDTO.from(user), HttpStatus.OK);
   }

   @PostMapping("/add")
   public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO user) {
      User newUser = userService.addUser(User.from(user));
      return new ResponseEntity<>(UserDTO.from(newUser), HttpStatus.CREATED);
   }

   @PutMapping("/update")
   public ResponseEntity<User> updateUser(@RequestBody UserDTO user) {
      User newUser = userService.addUser(User.from(user));
      return new ResponseEntity<>(newUser, HttpStatus.OK);
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
      userService.deleteUser(id);
      return new ResponseEntity<>(HttpStatus.OK);
   }

   @PostMapping("/add/{userId}")
   public ResponseEntity<UserDTO> addPlate(@PathVariable("userId") Long userId, @RequestBody RestaurantDTO restaurant) {
      Restaurant newRestaurant = restaurantService.addRestaurant(Restaurant.from(restaurant));
      User user = userService.addPlate(userId, newRestaurant.getId());
      return new ResponseEntity<>(UserDTO.from(user), HttpStatus.OK);
   }


   @DeleteMapping("/delete/{userId}/plate/{plateId}")
   public ResponseEntity<UserDTO> deletePlate(@PathVariable("userId") Long userId, @PathVariable("plateId") Long plateId) {
      User user = userService.removePlate(userId, plateId);
      return new ResponseEntity<>(UserDTO.from(user), HttpStatus.OK);
   }

}
