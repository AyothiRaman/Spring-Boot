package com.project.TraineeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.TraineeProject.entity.TaskAssignEntity;
import com.project.TraineeProject.repository.TaskAssignRepository;
import com.project.TraineeProject.service.TaskAssignService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/taskAssign")
public class TaskAssignController {
	
	@Autowired
	private TaskAssignService taskAssignService;
	
	@GetMapping
	public List<TaskAssignEntity> findData(){
		return taskAssignService.getAllData();
	}
	
	@PostMapping
	public TaskAssignEntity saveTaskAssignData(@RequestBody TaskAssignEntity entity) {
		return taskAssignService.saveData(entity);
	}

	@GetMapping("{id}")
	public ResponseEntity<TaskAssignEntity> getDataById( @PathVariable int id){
		return taskAssignService.getData(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<TaskAssignEntity> updateDataById(@PathVariable int id,@RequestBody TaskAssignEntity entity){
		return taskAssignService.updateData(id, entity);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteTaskAssignDetails(@PathVariable int id){
		return taskAssignService.deleteData(id);
	}
}
