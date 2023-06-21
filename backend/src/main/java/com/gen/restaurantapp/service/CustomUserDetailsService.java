package com.gen.restaurantapp.service;

import com.gen.restaurantapp.model.Admin;
import com.gen.restaurantapp.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        List<Admin> list = this.adminRepo.findAll();
        Admin userFound = null;
        for (int i=0; i<list.size();i++){
            if (list.get(i).getEmail().equals(email)) {
                userFound = list.get(i);
            }
        }

        if(userFound == null){
            throw new RuntimeException("User not found for email in the UserDetailsService :: "+email);
        }

        System.out.println(new SimpleGrantedAuthority(userFound.getRole()));

        return new org.springframework.security.core.userdetails.User(userFound.getEmail(), userFound.getPassword(), Arrays.stream(userFound.getRole().split(",")).collect(Collectors.toList()).stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList()));
    }

}
