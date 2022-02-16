package de.digitalcollections.iiif.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan(
    basePackages = {
      "org.mdz.dzp.interfaces.iiif.server.config",
      "de.digitalcollections.iiif.hymir.config",
    })
@SpringBootApplication
public class Application {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
  }
}
