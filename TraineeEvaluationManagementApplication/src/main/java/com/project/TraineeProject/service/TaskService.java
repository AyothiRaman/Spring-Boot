package com.project.TraineeProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.project.TraineeProject.entity.TaskEntity;
import com.project.TraineeProject.exception.ResourceNotFoundException;
import com.project.TraineeProject.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<TaskEntity> getAllData(){
		return taskRepository.findAll();
	}
	
	
	public TaskEntity saveData(TaskEntity entity) {
		return taskRepository.save(entity);
	}
	
	
	public ResponseEntity<TaskEntity> getDataById(int id){
		TaskEntity entity= taskRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Details not found"+ id));
		return ResponseEntity.ok(entity);
	}
	
	
	public ResponseEntity<TaskEntity> updateDetails(int id,TaskEntity entity){
		TaskEntity updateTask=taskRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("details not updated"+id));
				
				updateTask.setTaskName(entity.getTaskName());
		        updateTask.setStatus(entity.getStatus());
		         
		        taskRepository.save(updateTask);
		        
		        return ResponseEntity.ok(updateTask);
	
	}
	
	
	public ResponseEntity<HttpStatus> deleteDetails(int id){
		TaskEntity deleteEntity = taskRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("details are not available"+id));
	 
		taskRepository.delete(deleteEntity);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
