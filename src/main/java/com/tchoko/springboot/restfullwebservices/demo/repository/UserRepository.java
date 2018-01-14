package com.tchoko.springboot.restfullwebservices.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.tchoko.springboot.restfullwebservices.demo.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
