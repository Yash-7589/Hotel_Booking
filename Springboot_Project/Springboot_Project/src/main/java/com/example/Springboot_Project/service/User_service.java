package com.example.Springboot_Project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Springboot_Project.model.index;
@Service
public interface User_service {
    public index addUser(index obj);
    void deleteUser(int Id);
    List<index> selectUser();
    public index getUserById(int Id);
    void updatePassword(String username, String newPassword);

}
