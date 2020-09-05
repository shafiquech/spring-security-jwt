package com.sq.learning.dao.impl;

import com.sq.learning.authentication.ApplicationUser;
import com.sq.learning.dao.ApplicationUserDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
        Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
    ApplicationUser admin = new ApplicationUser("admin", passwordEncoder.encode("admin"),
        Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));

    List<ApplicationUser> applicationUsers = new ArrayList<>();
    applicationUsers.add(sara);
    applicationUsers.add(admin);

    return applicationUsers;
  }

}
