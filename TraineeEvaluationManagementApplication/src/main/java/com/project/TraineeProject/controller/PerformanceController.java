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

import com.project.TraineeProject.entity.PerformanceEntity;
import com.project.TraineeProject.service.PerformanceService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/performance")
public class PerformanceController {
	
	@Autowired
    private PerformanceService performanceService;
	
	@GetMapping
	public List<PerformanceEntity> findData(){
		return performanceService.getAllData();
	}
	
	@PostMapping
	public PerformanceEntity savePerformanceData(@RequestBody PerformanceEntity entity) {
		return performanceService.saveData(entity);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PerformanceEntity> getDetailsById(@PathVariable int id){
	return 	performanceService.getDataById(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity< PerformanceEntity> updateDetails(@PathVariable int id,@RequestBody PerformanceEntity entity){
		return performanceService.updateData(id, entity);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deletePerformanceDetails(@PathVariable int id){
		return performanceService.deleteData(id);
	}

}
