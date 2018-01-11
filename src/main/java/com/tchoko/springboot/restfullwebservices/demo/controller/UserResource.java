package com.tchoko.springboot.restfullwebservices.demo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tchoko.springboot.restfullwebservices.demo.exception.UserNotFoundException;
import com.tchoko.springboot.restfullwebservices.demo.model.UserEntity;
import com.tchoko.springboot.restfullwebservices.demo.service.UserEntityRepository;

@RestController
public class UserResource {

	@Autowired
	private UserEntityRepository userEntityRepository;

	@GetMapping("/jpa/users")
	public Iterable<UserEntity> retrieveAllUsers() {
		return userEntityRepository.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public UserEntity retrieveUser(@PathVariable int id) {
		UserEntity userEntity = userEntityRepository.findById(id).orElse(null);

		if (userEntity == null)
			throw new UserNotFoundException("id-" + id);

		return userEntity;
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userEntityRepository.deleteById(id);;
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@RequestBody UserEntity userEntity) {
		UserEntity savedUser = userEntityRepository.save(userEntity);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
}