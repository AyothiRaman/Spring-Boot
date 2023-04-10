package com.project.TraineeProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.TraineeProject.entity.TerminationEntity;
import com.project.TraineeProject.exception.ResourceNotFoundException;
import com.project.TraineeProject.repository.TerminationRepository;

@Service
public class TerminationService {
	
	
	@Autowired
	private TerminationRepository terminationRepository;
	
	public List<TerminationEntity> getAllData(){
		return terminationRepository.findAll();
	}
	
	public TerminationEntity saveData(TerminationEntity entity) {
		return terminationRepository.save(entity);
		
	}
	
	public ResponseEntity<TerminationEntity> getDataById(int id){
		TerminationEntity entity = terminationRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Details are not Available"+id));
		return ResponseEntity.ok(entity);
	}
	
	
	
	public ResponseEntity<TerminationEntity> updateData(int id,TerminationEntity entity){
		TerminationEntity updateEntity = terminationRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Details are not Available"));
		
		
		updateEntity.setName(entity.getName());
		updateEntity.setReason(entity.getReason());
		
		 terminationRepository.save(updateEntity);
		 
		 return ResponseEntity.ok(updateEntity);
		
	}
	
	public ResponseEntity<HttpStatus> deletedata(int id){
		TerminationEntity entity = terminationRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("details are not available"+id));
		
		terminationRepository.delete(entity);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
