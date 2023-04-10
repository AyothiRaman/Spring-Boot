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
@Table(name="Termination_List_Details")
public class TerminationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Reason")
	private String reason;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Termination_Date")
	private java.util.Date terminationDate = new Date(System.currentTimeMillis());


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	public java.util.Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(java.util.Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	
//	public TerminationEntity(int id, String name, String reason) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.reason = reason;
//	}


}
