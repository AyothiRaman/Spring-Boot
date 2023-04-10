package com.course.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.Entity.StudentEntity;
import com.course.Repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentrepository;
	
	// Method to find all the students 
	public List<StudentEntity> getAllData() {
		return studentrepository.findAll();
	}

	public  StudentEntity saveData(StudentEntity student) {
		return studentrepository.save(student);	
		
	}
	
	// Method to find All the  data in StudentDetails
	public Optional<StudentEntity> findData(long id) {
		return studentrepository.findById(id);
	}

	// Method to update the data by using id
	public String updateData(long id) {
		Optional<StudentEntity> ent = studentrepository.findById(id);
		
		if(ent.isPresent()) {
			studentrepository.saveAll(null);
			return "updated";
		}
		else {
			return "not updated";
		}
	}
	
     // Method to Delete the data By id
	
	public  String deleteData(long id) {
		Optional<StudentEntity> ent = studentrepository.findById(id);
	  
		if(ent.isPresent()) {
			studentrepository.deleteById(id);
			return "data deleted";
		}
		else {
			return "data not found";
		}
		
		
		
	}


}
