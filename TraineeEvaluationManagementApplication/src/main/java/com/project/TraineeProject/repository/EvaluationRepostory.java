package com.project.TraineeProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.TraineeProject.entity.EvaluationEntity;

public interface EvaluationRepostory extends JpaRepository<EvaluationEntity, Integer> {

}
