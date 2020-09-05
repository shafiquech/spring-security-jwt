package com.sq.learning.dao;

import com.sq.learning.authentication.ApplicationUser;
import java.util.Optional;

public interface ApplicationUserDao {
  Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
