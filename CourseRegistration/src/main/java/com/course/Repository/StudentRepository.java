package com.course.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.Entity.StudentCourseEntity;
import com.course.Entity.StudentEntity;
import com.course.Entity.UserEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {


	
	

	

}
