package com.sq.learning.security;

import static com.sq.learning.security.ApplicationUserPermission.COURSE_READ;
import static com.sq.learning.security.ApplicationUserPermission.COURSE_WRITE;
import static com.sq.learning.security.ApplicationUserPermission.CUSTOMER_READ;
import static com.sq.learning.security.ApplicationUserPermission.STUDENT_READ;
import static com.sq.learning.security.ApplicationUserPermission.STUDENT_WRITE;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum ApplicationUserRole {

  STUDENT(Sets.newHashSet()),
  ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE, CUSTOMER_READ)),
  ADMINTRAINEE(Sets.newHashSet(COURSE_READ, STUDENT_READ)),
  USER(Sets.newHashSet());

  private final Set<ApplicationUserPermission> permissions;

  ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
    this.permissions = permissions;
  }

  public Set<ApplicationUserPermission> getPermissions() {
    return permissions;
  }

  public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
    Set<SimpleGrantedAuthority> grantedAuthorities = getPermissions().stream()
        .map(p -> new SimpleGrantedAuthority(p.getPermission())).collect(
            Collectors.toSet());
    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return grantedAuthorities;
  }
}
