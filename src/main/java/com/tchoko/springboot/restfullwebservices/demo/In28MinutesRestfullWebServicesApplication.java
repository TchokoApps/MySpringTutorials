package com.tchoko.springboot.restfullwebservices.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tchoko.springboot.restfullwebservices.demo.model.UserEntity;
import com.tchoko.springboot.restfullwebservices.demo.service.UserEntityDaoService;

@SpringBootApplication
public class In28MinutesRestfullWebServicesApplication implements CommandLineRunner {
	
	@Autowired
	private UserEntityDaoService userEntityDaoService;

	public static void main(String[] args) {
		SpringApplication.run(In28MinutesRestfullWebServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserEntity userEntity = new UserEntity("Charles", new Date());
		userEntityDaoService.insert(userEntity);
		System.out.println("Persisted userEntity with id: " + userEntity);
	}
}
