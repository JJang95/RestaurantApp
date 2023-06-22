package com.gen.restaurantapp.repo;

import com.gen.restaurantapp.model.Admin;
import com.gen.restaurantapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo  extends JpaRepository<Admin, Long> {

//    void deleteAdminById(Long id);
//
}
