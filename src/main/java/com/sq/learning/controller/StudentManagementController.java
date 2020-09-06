package com.sq.learning.controller;

import com.google.common.collect.Lists;
import com.sq.learning.vo.Student;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

  private static final List<Student> STUDENTS = Lists.newArrayList(
      Student.builder().studentName("James Bond").studentId(1).build(),
      Student.builder().studentId(2).studentName("Maria Jones").build(),
      Student.builder().studentId(3).studentName("Anna Smith").build()
  );

//    hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission') hasAnyAuthority('permission')

  @GetMapping
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public List<Student> getAllStudents() {
    System.out.println("getAllStudents");
    return STUDENTS;
  }

  @PostMapping
  @PreAuthorize("hasAuthority('student:write')")
  public void registerNewStudent(@RequestBody Student student) {
    System.out.println("registerNewStudent");
    System.out.println(student);
  }

  @DeleteMapping(path = "{studentId}")
  @PreAuthorize("hasAuthority('student:write')")
  public void deleteStudent(@PathVariable("studentId") Integer studentId) {
    System.out.println("deleteStudent");
    System.out.println(studentId);
  }

  @PutMapping(path = "{studentId}")
  @PreAuthorize("hasAuthority('student:write')")
  public void updateStudent(@PathVariable("studentId") Integer studentId,
      @RequestBody Student student) {
    System.out.println("updateStudent");
    System.out.println(String.format("%s %s", studentId, student));
  }
}
