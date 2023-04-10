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

import com.project.TraineeProject.entity.TraineeEntity;
import com.project.TraineeProject.service.TraineeService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/trainee")
public class TraineeController {
	
	@Autowired
	private TraineeService traineeService;
	
	@GetMapping
	public List<TraineeEntity> findData(){
		return traineeService.getAllData();
	}
	
	@PostMapping
	public TraineeEntity saveTraineeData( @RequestBody TraineeEntity entity) {
		return traineeService.saveData(entity);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TraineeEntity> getTraineeDataById(@PathVariable int id){
		return traineeService.getDataById(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<TraineeEntity> updateTraineeData(@PathVariable int id,@RequestBody TraineeEntity entity){
		return traineeService.updateData(id, entity);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteTraineeDetailsById(@PathVariable int id){
		return traineeService.deleteData(id);
	}

}
