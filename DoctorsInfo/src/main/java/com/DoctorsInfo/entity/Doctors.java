package com.DoctorsInfo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DoctorsInfo")
public class Doctors {
	
	public Doctors() {
	}
	@Id
	@Column(name="id")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private Long age;
	@Column(name="gender")
	private String gender;
	@Column(name="specialistField")
	private String specialistField;
	
	public Doctors(Long id, String name, Long age, String gender, String specialistField) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.specialistField = specialistField;
	}
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
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSpecialistField() {
		return specialistField;
	}
	public void setSpecialistField(String specialistField) {
		this.specialistField = specialistField;
	}

}
