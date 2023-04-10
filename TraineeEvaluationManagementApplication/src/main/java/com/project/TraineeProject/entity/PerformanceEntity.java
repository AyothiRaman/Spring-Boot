package com.project.TraineeProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Performance_Details")
public class PerformanceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "Top_Five_Names")
	private String topFiveNames;

	@Column(name="Least_Five_names")
	private String leastFiveNames;
	
	@Column(name="Performance")
	private String performance;
	
	@Column(name="Average")
	private double average;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopFiveNames() {
		return topFiveNames;
	}

	public void setTopFiveNames(String topFiveNames) {
		this.topFiveNames = topFiveNames;
	}

	public String getLeastFiveNames() {
		return leastFiveNames;
	}

	public void setLeastFiveNames(String leastFiveNames) {
		this.leastFiveNames = leastFiveNames;
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

//	public PerformanceEntity(int id, String topFiveNames, String leastFiveNames, String performance, int average) {
//		super();
//		this.id = id;
//		this.topFiveNames = topFiveNames;
//		this.leastFiveNames = leastFiveNames;
//		this.performance = performance;
//		this.average = average;
//	}


}
