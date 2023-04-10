package com.course.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.Entity.StudentCourseEntity;

public interface StudentCourseRepository extends JpaRepository<StudentCourseEntity, Long> {
	


}
