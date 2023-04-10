package com.project.TraineeProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.TraineeProject.entity.TaskAssignEntity;
import com.project.TraineeProject.entity.TaskEntity;
import com.project.TraineeProject.exception.ResourceNotFoundException;
import com.project.TraineeProject.repository.TaskAssignRepository;

@Service
public class TaskAssignService {
	
	@Autowired
	private TaskAssignRepository taskAssignRepository;
	
	
	public List<TaskAssignEntity> getAllData(){
		return taskAssignRepository.findAll();		
	}
	
	public TaskAssignEntity saveData(TaskAssignEntity entity) {
		return taskAssignRepository.save(entity);
	}
	
	
	
	public ResponseEntity<TaskAssignEntity> getData(int id){
		TaskAssignEntity entity = taskAssignRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Details are not available"+id));
		return ResponseEntity.ok(entity);
	}
	
	

	public ResponseEntity<TaskAssignEntity> updateData(int id, TaskAssignEntity entity){
		TaskAssignEntity updateEntity = taskAssignRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("details Are not updated"+id));
		
		updateEntity.setAssignTo(entity.getAssignTo());
		updateEntity.setAssignStatus(entity.getAssignStatus());
		
		taskAssignRepository.save(updateEntity);
		
		return ResponseEntity.ok(updateEntity);
	}
	
	public ResponseEntity<HttpStatus> deleteData(int id){
		TaskAssignEntity entity = taskAssignRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("details Are not Available"+id));
		
		taskAssignRepository.delete(entity);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
