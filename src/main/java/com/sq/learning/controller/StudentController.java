package com.sq.learning.controller;

import com.google.common.collect.Lists;
import com.sq.learning.vo.Student;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

  private static final List<Student> STUDENTS = Lists.newArrayList(
      Student.builder().studentName("James Bond").studentId(1).build(),
      Student.builder().studentId(2).studentName("Maria Jones").build(),
      Student.builder().studentId(3).studentName("Anna Smith").build()
  );

  @GetMapping(path = "{studentId}")
  public Student getStudent(@PathVariable("studentId") Integer studentId) {
    return STUDENTS.stream()
        .filter(student -> studentId.equals(student.getStudentId()))
        .findFirst()
        .orElseThrow(() -> new IllegalStateException(
            "Student " + studentId + " does not exists"
        ));
  }
}
