package de.digitalcollections.iiif.serverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Demo IIIF Server (see https://spring.io/guides/gs/spring-boot/)<br>
 * Run: mvn package &amp;&amp; java -jar target/iiif-server-demo.jar
 */
@SpringBootApplication
/*
 @SpringBootApplication is a convenience annotation that adds all of the following:
 - @Configuration tags the class as a source of bean definitions for the application context.
 - @EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
 - Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.
 - @ComponentScan tells Spring to look for other components, configurations, and services in the current package (and subpackages), allowing it to find controllers, too.
 */
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
