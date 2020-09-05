package com.sq.learning.dao.impl;

import com.sq.learning.authentication.ApplicationUser;
import com.sq.learning.dao.ApplicationUserDao;
import com.sq.learning.repo.UserRepo;
import java.util.Collections;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DBApplicationUserDao implements ApplicationUserDao {

  public final UserRepo userRepo;

  @Override
  public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
    return userRepo.getByUsername(username)
        .map(user -> new ApplicationUser(user.getUsername(), user.getPassword(), Collections
            .singleton(new SimpleGrantedAuthority("ROLE_USER"))));
  }
}
