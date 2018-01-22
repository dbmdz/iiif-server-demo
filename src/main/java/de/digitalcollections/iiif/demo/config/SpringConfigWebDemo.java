package de.digitalcollections.iiif.demo.config;

import de.digitalcollections.iiif.demo.interceptor.ServerUrlInterceptor;
import de.digitalcollections.iiif.hymir.config.SpringConfigWeb;
import de.digitalcollections.iiif.hymir.frontend.ExtendedViewController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Import(SpringConfigWeb.class)
public class SpringConfigWebDemo extends WebMvcConfigurerAdapter {

  @Autowired
  private ServerUrlInterceptor serverUrlInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(serverUrlInterceptor);
  }

  @Bean
  public ExtendedViewController extendedViewController() {
    return new ExtendedViewController();
  }
}
