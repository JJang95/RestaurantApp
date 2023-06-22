package com.gen.restaurantapp.repo;

import com.gen.restaurantapp.model.Restaurant;
import com.gen.restaurantapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User, Long>
{
   void deleteUserById(Long id);
   Optional<User> findUserById(Long id);
}
