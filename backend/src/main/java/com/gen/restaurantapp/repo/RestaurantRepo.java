package com.gen.restaurantapp.repo;

import com.gen.restaurantapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
    void deleteRestaurantById(Long id);

    Optional<Restaurant> findRestaurantById(Long id);
}
