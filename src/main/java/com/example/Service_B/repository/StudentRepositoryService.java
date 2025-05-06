package com.example.Service_B.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Service_B.entity.StudentEntity;

public interface StudentRepositoryService extends JpaRepository<StudentEntity, Integer> {

}
