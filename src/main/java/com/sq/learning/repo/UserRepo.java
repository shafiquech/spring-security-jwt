package com.sq.learning.repo;

import com.sq.learning.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

  Optional<User> getByUsername(String username);
}
