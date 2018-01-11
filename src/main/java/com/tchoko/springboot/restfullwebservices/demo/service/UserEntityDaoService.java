package com.tchoko.springboot.restfullwebservices.demo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tchoko.springboot.restfullwebservices.demo.model.UserEntity;

@Repository
@Transactional
public class UserEntityDaoService {

	@PersistenceContext
	EntityManager entityManager;
	
	public long insert(UserEntity userEntity) {
		entityManager.persist(userEntity);
		return userEntity.getId();
	}
}
