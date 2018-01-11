package com.tchoko.springboot.restfullwebservices.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tchoko.springboot.restfullwebservices.demo.model.UserEntity;
import com.tchoko.springboot.restfullwebservices.demo.service.UserEntityRepository;

@SpringBootApplication
public class In28MinutesRestfullWebServicesApplication implements CommandLineRunner {
	
	@Autowired
	private UserEntityRepository userEntityRepository;

	public static void main(String[] args) {
		SpringApplication.run(In28MinutesRestfullWebServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserEntity userEntity = new UserEntity("Charles", new Date());
		userEntityRepository.save(userEntity);
		System.out.println("### User persisted: " + userEntity);
		
		UserEntity findById = userEntityRepository.findById(2).orElse(null);
		System.out.println("### User found: " + findById);
		
		Iterable<UserEntity> findAll = userEntityRepository.findAll();
		findAll.forEach(System.out::println);
	}
}
