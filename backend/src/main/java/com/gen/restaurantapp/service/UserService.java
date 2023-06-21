package com.gen.restaurantapp.service;

import com.gen.restaurantapp.exception.UserNotFoundException;
import com.gen.restaurantapp.model.Restaurant;
import com.gen.restaurantapp.model.User;
import com.gen.restaurantapp.repo.RestaurantRepo;
import com.gen.restaurantapp.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
   private final UserRepo userRepo;
   private final RestaurantRepo restRepo;
   private final RestaurantService restaurantService;

   @Autowired
   public UserService(UserRepo repo, RestaurantRepo restRepo, RestaurantService restaurantService) {
      this.userRepo = repo;
      this.restRepo = restRepo;
      this.restaurantService = restaurantService;
   }
   @Autowired
   private PasswordEncoder passwordEncoder;
   public User addUser(User user) {
      user.setPassword(passwordEncoder.encode(user.getPassword()));

      userRepo.save(user);

      return user;
   }

   public List<User> findAllUsers() {
      return userRepo.findAll();
   }


   public User findUserById(Long id) {
      return (User) userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
   }

   @Transactional
   public void deleteUser(Long id) {
      userRepo.deleteUserById(id);
   }
   @Transactional
   public User addPlate(Long userId, Long plateId) //Testing purposes, implement both creation and adding in same step later
   {
      User user = this.findUserById(userId);
      Restaurant plate = restaurantService.findRestaurantById(plateId);
      user.addPlate(plate);
      plate.setUser(user);
      return user;
   }
   @Transactional
   public User removePlate(Long userId, Long plateId) //Testing purposes, implement both creation and adding in same step later
   {
      User user = this.findUserById(userId);
      Restaurant plate = restaurantService.findRestaurantById(plateId);
      user.removePlate(plate);
      return user;
   }

   public List<Restaurant> findAllPlates(Long id)
   {
      return restRepo.findAllByuser_id(id);
   }
}
