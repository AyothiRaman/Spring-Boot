package com.project.TraineeProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Evaluation_Details")
public class EvaluationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="Employee_Name")
	private String employeeName;
	
	@Column(name="Task")
	private String task;
	
	@Column(name="Rating")
	private int rating;
	
	@Column(name="Review")
	private String review;
	
	@Column(name="Quality")
	private String quality;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}
	
//	public EvaluationEntity(int id, String employeeName, String task, int rating, String review, String quality) {
//		super();
//		this.id = id;
//		this.employeeName = employeeName;
//		this.task = task;
//		this.rating = rating;
//		this.review = review;
//		this.quality = quality;
//	}

}
