package com.tchoko.springboot.restfullwebservices.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min=2, message="Name should have atleast 2 characters")
	private String name;

	@Past
	private Date birthDate;

	protected UserEntity() {

	}
	
	public UserEntity(String name, Date birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}

	public UserEntity(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return String.format("\nUserEntity [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
	}

}