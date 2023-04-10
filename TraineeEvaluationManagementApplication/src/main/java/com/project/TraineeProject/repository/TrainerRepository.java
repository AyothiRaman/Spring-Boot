package com.project.TraineeProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.TraineeProject.entity.TrainerEntity;

public interface TrainerRepository extends JpaRepository<TrainerEntity, Integer> {

}
