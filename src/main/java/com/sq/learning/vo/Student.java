package com.sq.learning.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class Student {
  private final Integer studentId;
  private final String studentName;

}
