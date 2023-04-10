package com.course.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.Entity.StudentCourseEntity;
import com.course.Repository.StudentCourseRepository;

@Service
public class StudentCourseService {
	
	@Autowired
	StudentCourseRepository repo;
	
	public StudentCourseEntity saveCourse(StudentCourseEntity stu) {
		return repo.save(stu);
	}
	
	public List<StudentCourseEntity> getBookedDetails(){
		return repo.findAll();
	}

}
