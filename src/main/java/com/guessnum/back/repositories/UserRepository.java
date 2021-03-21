package com.guessnum.back.repositories;

import com.guessnum.back.entities.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
  
}
