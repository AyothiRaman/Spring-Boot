package com.project.TraineeProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.TraineeProject.entity.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {


	Optional<LoginEntity> findByUserName(String username);


}
