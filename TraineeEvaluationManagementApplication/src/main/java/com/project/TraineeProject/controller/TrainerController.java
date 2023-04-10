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

import com.project.TraineeProject.entity.TrainerEntity;
import com.project.TraineeProject.repository.TrainerRepository;
import com.project.TraineeProject.service.TrainerService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/trainer")
public class TrainerController {
	
	@Autowired
	private TrainerService trainerService;
	
	@GetMapping
	public List<TrainerEntity> findData(){
		return trainerService.getAllData();
	}
	
	@PostMapping
	public TrainerEntity saveTrainerdata( @RequestBody TrainerEntity entity) {
		return trainerService.saveData(entity);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TrainerEntity> getDataById( @PathVariable int id){
		return trainerService.getDataById(id);
	}
	
	@PutMapping("{id}")
	public  ResponseEntity<TrainerEntity> updateDataById(@PathVariable int id,@RequestBody TrainerEntity entity){
		return trainerService.updateDataById(id, entity);
	}
	
	
@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteData(@PathVariable int id){
		return trainerService.deleteData(id);
	}
}
