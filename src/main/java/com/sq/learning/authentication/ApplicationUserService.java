package com.sq.learning.authentication;

import com.sq.learning.dao.ApplicationUserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationUserService implements UserDetailsService {

  private final ApplicationUserDao applicationUserDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return applicationUserDao.selectApplicationUserByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found "));
  }
}
