package de.digitalcollections.iiif.serverdemo.config;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = {
  "de.digitalcollections.iiif.serverdemo.controller"
})
@PropertySource(value = {
  "classpath:de/digitalcollections/iiif/serverdemo/config/SpringConfigWeb-${spring.profiles.active:PROD}.properties"
})
public class SpringConfigWeb extends WebMvcAutoConfigurationAdapter {

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }
}
