package com.gen.restaurantapp.controller;

import com.gen.restaurantapp.model.Restaurant;
import com.gen.restaurantapp.model.User;
import com.gen.restaurantapp.service.RestaurantService;
import com.gen.restaurantapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
   private final UserService userService;

   public UserController(UserService userService) {
      this.userService = userService;
   }

   @GetMapping("/all")
   public ResponseEntity<List<User>> getAllUsers() {
      List<User> users = userService.findAllUsers();
      return new ResponseEntity<>(users, HttpStatus.OK);
   }

   @GetMapping("/find/{id}")
   public ResponseEntity<User> getUserById (@PathVariable("id") Long id) {
      User user = userService.findUserById(id);
      return new ResponseEntity<>(user, HttpStatus.OK);
   }

   @PostMapping("/add")
   public ResponseEntity<User> addUser(@RequestBody User user) {
      User newUser = userService.addUser(user);
      return new ResponseEntity<>(newUser, HttpStatus.CREATED);
   }

   @PutMapping("/update")
   public ResponseEntity<User> updateRestaurant(@RequestBody User user) {
      User newUser = userService.addUser(user);
      return new ResponseEntity<>(newUser, HttpStatus.OK);
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
      userService.deleteUser(id);
      return new ResponseEntity<>(HttpStatus.OK);
   }

   @PostMapping("/add/{userId}/plate/{plateId}")
   public ResponseEntity<User> addPlate(@PathVariable("userId") Long userId, @PathVariable("plateId") Long plateId) {
      User user = userService.addPlate(userId, plateId);
      return new ResponseEntity<>(user, HttpStatus.OK);
   }

   @DeleteMapping("/delete/{userId}/plate/{plateId}")
   public ResponseEntity<User> deletePlate(@PathVariable("userId") Long userId, @PathVariable("plateId") Long plateId) {
      User user = userService.removePlate(userId, plateId);
      return new ResponseEntity<>(user, HttpStatus.OK);
   }

}
