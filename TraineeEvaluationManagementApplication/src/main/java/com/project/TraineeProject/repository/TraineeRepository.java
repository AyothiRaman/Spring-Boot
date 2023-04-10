package com.project.TraineeProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.TraineeProject.entity.TraineeEntity;

@Repository
public interface TraineeRepository extends JpaRepository<TraineeEntity, Integer> {

}
