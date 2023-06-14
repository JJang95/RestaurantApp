package com.gen.restaurantapp.service;

import com.gen.restaurantapp.exception.UserNotFoundException;
import com.gen.restaurantapp.model.Restaurant;
import com.gen.restaurantapp.repo.RestaurantRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepo restaurantRepo;

    @Autowired
    public RestaurantService(RestaurantRepo bookRepo) {
        this.restaurantRepo = bookRepo;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    public List<Restaurant> findAllRestaurants() {
        return restaurantRepo.findAll();
    }

    public Restaurant updateRestaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    public Restaurant findRestaurantById(Long id) {
        return (Restaurant) restaurantRepo.findRestaurantById(id).orElseThrow(() -> new UserNotFoundException("Book by id " + id + " was not found"));
    }

    @Transactional
    public void deleteRestaurant(Long id) {
        restaurantRepo.deleteRestaurantById(id);
    }
}
