package com.sq.learning.dao.impl;

import static com.sq.learning.security.ApplicationUserRole.ADMIN;
import static com.sq.learning.security.ApplicationUserRole.ADMINTRAINEE;
import static com.sq.learning.security.ApplicationUserRole.STUDENT;
import static com.sq.learning.security.ApplicationUserRole.USER;

import com.sq.learning.authentication.ApplicationUser;
import com.sq.learning.dao.ApplicationUserDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Primary
@Service
@RequiredArgsConstructor
public class MockApplicationUserDao implements ApplicationUserDao {

  private final PasswordEncoder passwordEncoder;

  @Override
  public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
    return getApplicationUsers()
        .stream()
        .filter(applicationUser -> username.equals(applicationUser.getUsername()))
        .findFirst();
  }


  private List<ApplicationUser> getApplicationUsers() {
    ApplicationUser sara = new ApplicationUser("sara", passwordEncoder.encode("sara"),
        USER.getGrantedAuthorities());
    ApplicationUser admin = new ApplicationUser("admin", passwordEncoder.encode("admin"),
        ADMIN.getGrantedAuthorities());
    ApplicationUser student = new ApplicationUser("sara", passwordEncoder.encode("sara"),
        STUDENT.getGrantedAuthorities());
    ApplicationUser adminTrainee = new ApplicationUser("admin", passwordEncoder.encode("admin"),
        ADMINTRAINEE.getGrantedAuthorities());

    List<ApplicationUser> applicationUsers = new ArrayList<>();
    applicationUsers.add(sara);
    applicationUsers.add(admin);
    applicationUsers.add(student);
    applicationUsers.add(adminTrainee);
    return applicationUsers;
  }

}
