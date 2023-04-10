package com.project.TraineeProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.TraineeProject.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

}
