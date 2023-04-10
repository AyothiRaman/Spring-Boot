package com.project.TraineeProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.TraineeProject.entity.PerformanceEntity;

public interface PerformanceRepository extends JpaRepository<PerformanceEntity, Integer> {

}
