package com.tchoko.springboot.restfullwebservices.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.tchoko.springboot.restfullwebservices.demo.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {

}
