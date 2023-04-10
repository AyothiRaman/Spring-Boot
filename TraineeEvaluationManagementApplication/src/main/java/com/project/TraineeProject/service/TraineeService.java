package com.project.TraineeProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.TraineeProject.entity.TraineeEntity;
import com.project.TraineeProject.exception.ResourceNotFoundException;
import com.project.TraineeProject.repository.TraineeRepository;

@Service
public class TraineeService {
	
	@Autowired
	private TraineeRepository traineeRepository;
	
	// Method to find List of all Trainee Details
	
	public List<TraineeEntity> getAllData(){
		return traineeRepository.findAll();
	}
	
	// Method to save Details of all Trainee
	public TraineeEntity saveData(TraineeEntity entity) {
		return traineeRepository.save(entity);
	}
	
	// Method to get Data by id
	
	public ResponseEntity<TraineeEntity> getDataById(int id){
		TraineeEntity entity = traineeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("details Not Available +id"));
		return ResponseEntity.ok(entity);
	}
	
	
	// Method to update the data by Using Id
	
	public ResponseEntity<TraineeEntity> updateData(int id,TraineeEntity entity){
		TraineeEntity UpdateEntity = traineeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Details Not updated"+id));
		
	UpdateEntity.setName(entity.getName());
	UpdateEntity.setTechnology(entity.getTechnology());
	
	traineeRepository.save(UpdateEntity);
	
	return ResponseEntity.ok(UpdateEntity);
		
	}

	// Method to delete the data by using id

	public ResponseEntity<HttpStatus> deleteData(int id){
		TraineeEntity entity = traineeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("details are not available"+id));
		
		traineeRepository.delete(entity);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
