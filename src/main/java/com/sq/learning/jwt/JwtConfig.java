package com.sq.learning.jwt;

import com.google.common.net.HttpHeaders;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "app.jwt")
@Configuration
public class JwtConfig {
  private String secretKey;
  private String tokenPrefix;
  private Integer tokenExpirationAfterDays;

  public String getAuthorizationHeader() {
    return HttpHeaders.AUTHORIZATION;
  }
}
