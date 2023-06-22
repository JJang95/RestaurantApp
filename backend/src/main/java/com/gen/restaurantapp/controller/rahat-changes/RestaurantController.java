package com.gen.restaurantapp;

import com.gen.restaurantapp.model.Admin;
import com.gen.restaurantapp.model.Restaurant;
import com.gen.restaurantapp.model.dto.RestaurantDTO;
import com.gen.restaurantapp.service.AdminService;
import com.gen.restaurantapp.service.RestaurantService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    @GetMapping("/authentication")
    public boolean getAuthentication(){
        return true;
    }
    @Autowired
    public AdminService adminService;

    @GetMapping("")
    public String getHome(){
        return "Hello World";
    }

    @GetMapping("restaurant/all")
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.findAllRestaurants();
        List<RestaurantDTO> restaurantDTOS = restaurants.stream().map(RestaurantDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(restaurantDTOS, HttpStatus.OK);
    }
//    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
//        List<Restaurant> restaurants = restaurantService.findAllRestaurants();
//        return new ResponseEntity<>(restaurants, HttpStatus.OK);
//    }



    @GetMapping("restaurant/find/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById (@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantService.findRestaurantById(id);
        return new ResponseEntity<>(RestaurantDTO.from(restaurant), HttpStatus.OK);
    }
//    public ResponseEntity<Restaurant> getRestaurantById (@PathVariable("id") Long id) {
//        Restaurant restaurant = restaurantService.findRestaurantById(id);
//        return new ResponseEntity<>(restaurant, HttpStatus.OK);
//    }

    @PostMapping("restaurant/add")
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody RestaurantDTO restaurant) {
        Restaurant newRestaurant = restaurantService.addRestaurant(Restaurant.from(restaurant));
        return new ResponseEntity<>(RestaurantDTO.from(newRestaurant), HttpStatus.CREATED);
    }
//    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
//        Restaurant newRestaurant = restaurantService.addRestaurant(restaurant);
//        return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
//    }

    @PutMapping("restaurant/update")
    public ResponseEntity<RestaurantDTO> updateRestaurant(@RequestBody RestaurantDTO restaurant) {
        Restaurant updateRestaurant = restaurantService.updateRestaurant(Restaurant.from(restaurant));
        return new ResponseEntity<>(RestaurantDTO.from(updateRestaurant), HttpStatus.OK);
    }
//    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant) {
//        Restaurant updateRestaurant = restaurantService.updateRestaurant(restaurant);
//        return new ResponseEntity<>(updateRestaurant, HttpStatus.OK);
//    }

    @DeleteMapping("restaurant/delete/{id}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.deleteRestaurant(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("admin/all")
    public ResponseEntity<List<Admin>> getAllAdmins(){
        List<Admin> a = adminService.findAllAdmins();
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @GetMapping("admin/find/{id}")
    public ResponseEntity<Admin> getAdminById (@PathVariable("id") Long id){
        Admin a = adminService.findAdminById(id);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @PostMapping("admin/add")
    public ResponseEntity<Admin> addRestaurant(@RequestBody Admin a) {
        Admin newAdmin = adminService.addAdmin(a);
        return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
    }
    @PutMapping("admin/update")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin a){
        Admin updateAdmin = adminService.updateAdmin(a);
        return new ResponseEntity<>(updateAdmin, HttpStatus.OK);
    }
    @DeleteMapping("admin/delete/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable("id") Long id){
        adminService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
/**

 @DeleteMapping("restaurant/delete/{id}")
 public ResponseEntity<?> deleteRestaurant(@PathVariable("id") Long id) {
 restaurantService.deleteRestaurant(id);
 return new ResponseEntity<>(HttpStatus.OK);
 }

 */
