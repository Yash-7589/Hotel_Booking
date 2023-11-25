package com.example.Springboot_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Springboot_Project.model.index;

public interface Index_repo extends JpaRepository<index, Integer> {
    index findByUsername(String username);
}
