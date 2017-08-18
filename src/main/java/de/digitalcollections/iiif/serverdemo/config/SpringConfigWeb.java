package de.digitalcollections.iiif.serverdemo.config;

import de.digitalcollections.commons.springmvc.config.SpringConfigCommonsMvc;
import de.digitalcollections.commons.springmvc.controller.ErrorController;
import de.digitalcollections.iiif.serverdemo.interceptor.ServerUrlInterceptor;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
@ComponentScan(basePackages = {
  "de.digitalcollections.commons.springmvc.controller",
  "de.digitalcollections.iiif.serverdemo.controller"
}, excludeFilters = {
  @ComponentScan.Filter(value = ErrorController.class, type = FilterType.ASSIGNABLE_TYPE)
})
@Import(SpringConfigCommonsMvc.class)
public class SpringConfigWeb extends WebMvcConfigurerAdapter { // implements EmbeddedServletContainerCustomizer

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Autowired
  private SpringTemplateEngine templateEngine;

  @Autowired
  @Qualifier("CommonsClasspathThymeleafResolver")
  private ClassLoaderTemplateResolver commonsClasspathThymeleafResolver;

  @Bean
  public ServerUrlInterceptor serverUrlInterceptor() {
    ServerUrlInterceptor serverUrlInterceptor = new ServerUrlInterceptor();
    return serverUrlInterceptor;
  }

  @PostConstruct
  public void extension() {
    commonsClasspathThymeleafResolver.setOrder(1);
    templateEngine.addTemplateResolver(commonsClasspathThymeleafResolver);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(serverUrlInterceptor());
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
}
