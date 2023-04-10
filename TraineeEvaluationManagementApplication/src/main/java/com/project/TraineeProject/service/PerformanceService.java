package com.project.TraineeProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.TraineeProject.entity.PerformanceEntity;
import com.project.TraineeProject.exception.ResourceNotFoundException;
import com.project.TraineeProject.repository.PerformanceRepository;

@Service
public class PerformanceService {
	
	@Autowired
	private PerformanceRepository performanceRepository;
	
	public List<PerformanceEntity> getAllData(){
		return performanceRepository.findAll();
	}

	public PerformanceEntity saveData(PerformanceEntity entity) {
		return performanceRepository.save(entity);
	}
	
	public ResponseEntity<PerformanceEntity> getDataById(int id){
		PerformanceEntity entity = performanceRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("details are not available"+id));
		return ResponseEntity.ok(entity);
	}
	
	public ResponseEntity<PerformanceEntity> updateData(int id,PerformanceEntity entity){
		PerformanceEntity updateEntity = performanceRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("details are not available"+id));
		
		updateEntity.setTopFiveNames(entity.getTopFiveNames());
		updateEntity.setLeastFiveNames(entity.getLeastFiveNames());
		updateEntity.setAverage(entity.getAverage());
		updateEntity.setPerformance(entity.getPerformance());
		
		performanceRepository.save(updateEntity);
		
	return 	ResponseEntity.ok(updateEntity);
		
		
		
	}
	
	public ResponseEntity<HttpStatus> deleteData(int id){
		PerformanceEntity entity = performanceRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("details are not available"+id));
		
		performanceRepository.delete(entity);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
