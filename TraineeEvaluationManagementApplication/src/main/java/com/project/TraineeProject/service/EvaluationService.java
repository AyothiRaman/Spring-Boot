package com.project.TraineeProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.TraineeProject.entity.EvaluationEntity;
import com.project.TraineeProject.exception.ResourceNotFoundException;
import com.project.TraineeProject.repository.EvaluationRepostory;

@Service
public class EvaluationService {
	
	@Autowired
	private EvaluationRepostory evaluationRepostory;

	public List<EvaluationEntity> getAllData() {
		return evaluationRepostory.findAll();
	}
	
	public EvaluationEntity saveData(EvaluationEntity entity) {
		return evaluationRepostory.save(entity);
	}

	
	public ResponseEntity<EvaluationEntity> getData(int id){
		EvaluationEntity entity = evaluationRepostory.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("details are not Available"+id));
		return ResponseEntity.ok(entity);
	}
	
	public ResponseEntity<EvaluationEntity> updateData(int id, EvaluationEntity entity){
		EvaluationEntity updateEntity = evaluationRepostory.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("details Are not updated"+id));
		
		updateEntity.setEmployeeName(entity.getEmployeeName());
		updateEntity.setRating(entity.getRating());
		updateEntity.setTask(entity.getTask());
		updateEntity.setQuality(entity.getQuality());
		updateEntity.setReview(entity.getReview());
		
		evaluationRepostory.save(updateEntity);
		
		return ResponseEntity.ok(updateEntity);
		
	}
	
	public ResponseEntity<HttpStatus> deleteData(int id){
		EvaluationEntity entity = evaluationRepostory.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("details Not available"+id));
		
		evaluationRepostory.delete(entity);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
