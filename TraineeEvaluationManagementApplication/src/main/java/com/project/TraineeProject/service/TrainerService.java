package com.project.TraineeProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.TraineeProject.entity.TrainerEntity;
import com.project.TraineeProject.exception.ResourceNotFoundException;
import com.project.TraineeProject.repository.TrainerRepository;

@Service
public class TrainerService {
	
	@Autowired
	private TrainerRepository trainerRepository;
	
	public List<TrainerEntity> getAllData(){
		return trainerRepository.findAll();
	}
	
	public TrainerEntity saveData(TrainerEntity entity) {
		return trainerRepository.save(entity);
	}
	
	
	public ResponseEntity<TrainerEntity> getDataById(int id){
		TrainerEntity entity =  trainerRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Details Not Available"+id));
		return ResponseEntity.ok(entity);
	}
	
	public ResponseEntity<TrainerEntity> updateDataById(int id,TrainerEntity entity){
		TrainerEntity updateEntity= trainerRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("details are not Updated"+id));
		
		updateEntity.setName(entity.getName());
		updateEntity.setEmailId(entity.getEmailId());
		updateEntity.setTeam(entity.getTeam());
		trainerRepository.save(updateEntity);
		
	return	ResponseEntity.ok(updateEntity);
		
	}
	
	public ResponseEntity<HttpStatus> deleteData(int id){
		TrainerEntity entity = trainerRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Details are not found"+id));
				
				trainerRepository.delete(entity);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
