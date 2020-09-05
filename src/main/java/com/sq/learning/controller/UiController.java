package com.sq.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UiController {

  @GetMapping("login")
  public String login() {
    return "login";
  }

  @GetMapping("index")
  public String home() {
    return "index";
  }
  @GetMapping("register")
  public String register() {
    return "register";
  }
}
