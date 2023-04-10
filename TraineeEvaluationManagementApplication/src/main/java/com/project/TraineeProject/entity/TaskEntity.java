package com.project.TraineeProject.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Task_Details")
public class TaskEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="Task_Name")
	private String taskName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Task_Date")
	private java.util.Date taskDate = new Date(System.currentTimeMillis());
	
	@Column(name="Status")
	private String status;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public java.util.Date getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(java.util.Date taskDate) {
		this.taskDate = taskDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public TaskEntity(int id, String taskName, java.util.Date taskDate, String status) {
//		super();
//		this.id = id;
//		this.taskName = taskName;
//		this.taskDate = taskDate;
//		this.status = status;
//	}
	
	

}
