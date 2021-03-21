package com.guessnum.back.controllers;

import com.guessnum.back.entities.User;
import com.guessnum.back.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/users")
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @PostMapping(path = "/new")
  public @ResponseBody String createNewUser(@RequestParam("name") String name) {
    User user = new User();

    user.setName(name);
    if (userRepository.save(user) != null ) {
      return "Success, user created";
    }

    return "Error, user not created";
  }

  @GetMapping(path = "/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
}
