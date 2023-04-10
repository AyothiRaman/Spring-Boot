package com.course.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.Entity.CourseEntity;
import com.course.Entity.StudentEntity;
import com.course.Repository.CourseRepository;
import com.course.Repository.StudentRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courserepository;
	
	@Autowired
	StudentRepository repo;
	
	// Method to find all courses that are available 
	public List<CourseEntity> findCourse() {
		return courserepository.findAll();
	}
	
	// Method to save the Data
	public CourseEntity saveCourse(CourseEntity entity){
		return courserepository.save(entity);
		
	}

	public Optional<CourseEntity> findByUserName(String username) {
	
		return courserepository.findByCourseName(username);
	}

	public StudentEntity courseDetails(StudentEntity ent) {
		return repo.save(ent);
	}
	
		
		
	}


