package com.sq.learning.controller;

import com.google.common.collect.Lists;
import com.sq.learning.vo.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class CustomerController {

  @GetMapping("/customers")
  @PreAuthorize("hasAuthority('customer:read')")
  public ResponseEntity<List<Customer>> getStudents() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    ArrayList<Customer> customers = Lists
        .newArrayList(Customer.builder().customerName("james").phone("77303000").address("3004 VA")
            .active(Boolean.TRUE).build());
    return new ResponseEntity<>(customers, HttpStatus.OK);
  }

}
