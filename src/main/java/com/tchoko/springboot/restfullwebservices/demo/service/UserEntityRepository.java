package com.tchoko.springboot.restfullwebservices.demo.service;

import org.springframework.data.repository.CrudRepository;

import com.tchoko.springboot.restfullwebservices.demo.model.UserEntity;

public interface UserEntityRepository extends CrudRepository<UserEntity, Integer>{

}
