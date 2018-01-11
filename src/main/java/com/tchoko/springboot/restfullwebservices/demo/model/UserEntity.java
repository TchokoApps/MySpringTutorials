package com.tchoko.springboot.restfullwebservices.demo.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private Date birthDate;

	@OneToMany(mappedBy = "post")
	Set<Post> posts = new HashSet<>();

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

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