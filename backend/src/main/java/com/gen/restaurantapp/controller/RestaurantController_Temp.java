package com.gen.restaurantapp.controller;

import com.gen.restaurantapp.model.Restaurant;
import com.gen.restaurantapp.model.dto.RestaurantDTO;
import com.gen.restaurantapp.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
//Don't use directly, for admin or testing purposes only.
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
   private final RestaurantService restaurantService;

   public RestaurantController(RestaurantService restaurantService) {
      this.restaurantService = restaurantService;
   }

   @GetMapping("/all")
   public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
      List<Restaurant> restaurants = restaurantService.findAllRestaurants();
      List<RestaurantDTO> restaurantDTOS = restaurants.stream().map(RestaurantDTO::from).collect(Collectors.toList());
      return new ResponseEntity<>(restaurantDTOS, HttpStatus.OK);
   }

   @GetMapping("/find/{id}")
   public ResponseEntity<RestaurantDTO> getRestaurantById (@PathVariable("id") Long id) {
      Restaurant restaurant = restaurantService.findRestaurantById(id);
      return new ResponseEntity<>(RestaurantDTO.from(restaurant), HttpStatus.OK);
   }

   @PostMapping("/add")
   public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody RestaurantDTO restaurant) {
      Restaurant newRestaurant = restaurantService.addRestaurant(Restaurant.from(restaurant));
      return new ResponseEntity<>(RestaurantDTO.from(newRestaurant), HttpStatus.CREATED);
   }

   @PutMapping("/update")
   public ResponseEntity<RestaurantDTO> updateRestaurant(@RequestBody RestaurantDTO restaurant) {
      Restaurant updateRestaurant = restaurantService.updateRestaurant(Restaurant.from(restaurant));
      return new ResponseEntity<>(RestaurantDTO.from(updateRestaurant), HttpStatus.OK);
   }

   @DeleteMapping("/delete/{id}") //Might run into issues
   public ResponseEntity<?> deleteRestaurant(@PathVariable("id") Long id) {
      restaurantService.deleteRestaurant(id);
      return new ResponseEntity<>(HttpStatus.OK);
   }



}
