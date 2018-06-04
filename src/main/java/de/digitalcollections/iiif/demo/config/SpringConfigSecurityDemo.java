package de.digitalcollections.iiif.demo.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringConfigSecurityDemo extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .headers().frameOptions().disable() // to make universalviewer work
            .and()
            .authorizeRequests()
            .requestMatchers(EndpointRequest.to("info", "health")).permitAll()
            .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ACTUATOR")
            .antMatchers("/**").permitAll()
            .and()
            .httpBasic();
  }

}
