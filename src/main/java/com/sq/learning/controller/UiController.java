package com.sq.learning.controller;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UiController {

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/index")
  public String home() {
    return "index";
  }

  @GetMapping("/register")
  public String register() {
    return "register";
  }

  @RequestMapping("user")
  @ResponseBody
  public Principal user(Principal principal) {
    return principal;

  }
}
