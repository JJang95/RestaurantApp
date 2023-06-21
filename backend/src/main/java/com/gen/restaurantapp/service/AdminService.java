package com.gen.restaurantapp.service;

import com.gen.restaurantapp.exception.UserNotFoundException;
import com.gen.restaurantapp.model.Admin;
import com.gen.restaurantapp.model.Restaurant;
import com.gen.restaurantapp.repo.AdminRepo;
import com.gen.restaurantapp.repo.RestaurantRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    public PasswordEncoder passwordEncoder;

    public Admin addAdmin(Admin a){
        a.setPassword(passwordEncoder.encode(a.getPassword()));
        return adminRepo.save(a);
    }

    public List<Admin> findAllAdmins(){
        return adminRepo.findAll();
    }

    public Admin updateAdmin(Admin a){
        a.setPassword(passwordEncoder.encode(a.getPassword()));
        return adminRepo.save(a);
    }

    public Admin findAdminById(Long id){
        return (Admin) adminRepo.findById(id).orElseThrow(()->new UserNotFoundException("Admin by id "+ id+ " was not found"));
    }
    public String deleteUserById(long Id){
        this.adminRepo.deleteById(Id);
        return "Deleted Successfully";
    }



}
/**

    public Restaurant findRestaurantById(Long id) {
        return (Restaurant) restaurantRepo.findRestaurantById(id).orElseThrow(() -> new UserNotFoundException("Book by id " + id + " was not found"));
    }

    @Transactional
    public void deleteRestaurant(Long id) {
        restaurantRepo.deleteRestaurantById(id);
    }
}
 **/