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

import com.project.TraineeProject.entity.EvaluationEntity;
import com.project.TraineeProject.service.EvaluationService;


@CrossOrigin("*")
@RestController
@RequestMapping("api/evaluation")
public class EvaluationController {
	
   @Autowired
   private EvaluationService evaluationService;
   
   @GetMapping
   public List<EvaluationEntity> findData(){
	   return evaluationService.getAllData();
   }
   
   @PostMapping
   public EvaluationEntity saveEvaluationData(@RequestBody EvaluationEntity entity) {
	   return evaluationService.saveData(entity);
	   
   }
   
   @GetMapping("{id}")
   public ResponseEntity<EvaluationEntity> getDataById( @PathVariable int id){
	   return evaluationService.getData(id);
   }
 
   @PutMapping("{id}")
   public ResponseEntity<EvaluationEntity> updateDataById(@PathVariable int id, @RequestBody EvaluationEntity entity){
	   return evaluationService.updateData(id, entity);
   }
   
   @DeleteMapping("{id}")
   public ResponseEntity<HttpStatus> deleteEvaluationDetails(@PathVariable int id){
	   return evaluationService.deleteData(id);
   }
}
