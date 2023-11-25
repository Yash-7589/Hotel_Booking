package com.example.Springboot_Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Springboot_Project.model.index;
import com.example.Springboot_Project.repository.Index_repo;
@Service
public class User_serviceIMPL implements User_service {
    @Autowired
    Index_repo repository;
    @Override
    public index addUser(index obj) {
        return repository.save(obj);
    }
    @Override
    public void deleteUser(int Id) {
        repository.deleteById(Id);
        System.out.println("User With ID "+Id+" is deleted");
    }
    @Override
    public List<index> selectUser() {
        return repository.findAll();
    }
    @Override
    public index getUserById(int Id) {
         return repository.findById(Id).orElse(null);
    }
    @Override
public void updatePassword(String username, String newPassword) {
    index user = repository.findByUsername(username);

    if (user != null) {
        user.setPassword(newPassword);
        repository.save(user);
    }
}
    
}
