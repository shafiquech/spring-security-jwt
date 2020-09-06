package com.sq.learning.vo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Customer {

  private String customerName;
  private String phone;
  private String address;
  private Boolean active;
}
