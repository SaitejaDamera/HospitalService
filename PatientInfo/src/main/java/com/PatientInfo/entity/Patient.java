package com.PatientInfo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="PatientInfo")
public class Patient {
	
	@Id
	
	@Column(name="id")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="visitedDoctor")
	private String visitedDoctor;
	
	@Column(name="dateOfVisit")
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date dateOfVisit  ;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVisitedDoctor() {
		return visitedDoctor;
	}

	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	
	public Patient() {
		
	}

	public Patient(Long id, String name, String visitedDoctor, Date dateOfVisit) {
		super();
		this.id = id;
		this.name = name;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
	}

}
