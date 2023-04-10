package com.project.TraineeProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.TraineeProject.entity.TraineeEntity;
import com.project.TraineeProject.repository.TraineeRepository;

@SpringBootApplication
public class TraineeEvaluationManagementApplication implements CommandLineRunner {
	

	public static void main(String[] args) {
		SpringApplication.run(TraineeEvaluationManagementApplication.class, args);
	}
	

	@Autowired
	TraineeRepository traineeRepository;

	@Override
	public void run(String... args) throws Exception {
//		
//		TraineeEntity trainee = new TraineeEntity();
//		
//		trainee.setName("sara");
//		trainee.setTechnology("SQL");
//		
//		traineeRepository.save(trainee);
//		
//		
		
	
		
	}

}
