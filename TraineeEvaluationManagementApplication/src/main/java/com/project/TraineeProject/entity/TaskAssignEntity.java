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
@Table(name="Task_Assign_Details")
public class TaskAssignEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="Assign_To")
	private String assignTo;
	
	@Column(name="Assign_Status")
	private String assignStatus;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date")
	private java.util.Date date = new Date(System.currentTimeMillis());
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssignStatus() {
		return assignStatus;
	}

	public void setAssignStatus(String assignStatus) {
		this.assignStatus = assignStatus;
	}

	public String getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

//	public TaskAssignEntity(int id, String assignTo, String status, java.util.Date date) {
//		super();
//		this.id = id;
//		this.assignTo = assignTo;
//		this.status = status;
//		this.date = date;
//	}

	

}
