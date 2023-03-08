package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.project.model.studentmodel;

public interface repository extends JpaRepository<studentmodel, Integer> {

}
