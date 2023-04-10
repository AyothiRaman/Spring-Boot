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

import com.project.TraineeProject.entity.TerminationEntity;
import com.project.TraineeProject.service.TerminationService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/termination")
public class TerminationController {
	
	@Autowired
	private TerminationService terminationService;
	
	@GetMapping
	public List<TerminationEntity> findData(){
		return terminationService.getAllData();
	}
	
	@PostMapping
	public TerminationEntity saveTerminationData(@RequestBody TerminationEntity entity) {
		return terminationService.saveData(entity);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TerminationEntity> getDataById(@PathVariable int id){
		return terminationService.getDataById(id);
		
	}
	
	@PutMapping("{id}")
    public ResponseEntity<TerminationEntity> updateDataById(@PathVariable int id,@RequestBody TerminationEntity entity){
			return terminationService.updateData(id, entity);
		}
	
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteTerminationDetails(@PathVariable int id){
		return terminationService.deletedata(id);
	}

}
