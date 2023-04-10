package com.course.Entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="StudentCourseDetails")
public class StudentCourseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	@Column(name="student_Id")
	private Integer studentId;
	@Column(name="course_Id")
	private Integer courseId;	
	
	@Column(name="courseName")
	private String CourseName;
	
	@Column(name="booking_time")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date bookingTime = new Date(System.currentTimeMillis());

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public java.util.Date getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(java.util.Date bookingTime) {
		this.bookingTime = bookingTime;
	}
	
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	
}
