package com.project.TraineeProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.TraineeProject.entity.TaskEntity;
import com.project.TraineeProject.service.TaskService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public List<TaskEntity> findData(){
		return taskService.getAllData();
	}
	
	@PostMapping
	public TaskEntity saveTaskData( @RequestBody TaskEntity entity) {
		return taskService.saveData(entity);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TaskEntity> getDataById( @PathVariable int id){
		return taskService.getDataById(id);
	}
	
	@PutMapping("{id}")
	public  ResponseEntity<TaskEntity> updateTaskData(@PathVariable int id,@RequestBody TaskEntity entity) {
		return taskService.updateDetails(id, entity);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteTaskDetails(@PathVariable int id){
		return taskService.deleteDetails(id);
	}

}
