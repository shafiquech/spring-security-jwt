package com.sq.learning.controller;

import com.sq.learning.model.User;
import com.sq.learning.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

  private final UserRepo userRepo;
  private final PasswordEncoder passwordEncoder;

  @GetMapping(path = "/{username}")
  public String createUser(@PathVariable(value = "username") String username) {

    User user = new User();
    user.setUsername(username);
    user.setPassword(passwordEncoder.encode(username));

    user = userRepo.save(user);

    return user.getId() + " << User Saved >> " + user.getPassword();
  }


}
