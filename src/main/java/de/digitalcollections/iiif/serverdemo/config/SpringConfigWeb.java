package de.digitalcollections.iiif.serverdemo.config;

import de.digitalcollections.iiif.serverdemo.interceptor.ServerUrlInterceptor;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
@ComponentScan(basePackages = {
  "de.digitalcollections.iiif.serverdemo.controller"
})
@PropertySource(value = {
  "classpath:de/digitalcollections/iiif/serverdemo/config/SpringConfigWeb-${spring.profiles.active:PROD}.properties"
})
public class SpringConfigWeb extends WebMvcAutoConfigurationAdapter { // implements EmbeddedServletContainerCustomizer

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
  public ServerUrlInterceptor serverUrlInterceptor() {
    ServerUrlInterceptor serverUrlInterceptor = new ServerUrlInterceptor();
    return serverUrlInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(serverUrlInterceptor());
  }
}
