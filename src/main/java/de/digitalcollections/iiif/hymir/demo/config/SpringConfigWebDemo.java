package de.digitalcollections.iiif.hymir.demo.config;

import de.digitalcollections.iiif.hymir.demo.interceptor.ServerUrlInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration(value = "SpringConfigWebDemo")
public class SpringConfigWebDemo extends WebMvcConfigurerAdapter {

  @Autowired
  private ServerUrlInterceptor serverUrlInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(serverUrlInterceptor);
  }
}
