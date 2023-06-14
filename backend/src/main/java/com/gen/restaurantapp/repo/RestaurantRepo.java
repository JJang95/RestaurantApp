package com.gen.restaurantapp.repo;

import com.gen.restaurantapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
    void deleteRestaurantById(Long id);

    Optional<Restaurant> findRestaurantById(Long id);
}
