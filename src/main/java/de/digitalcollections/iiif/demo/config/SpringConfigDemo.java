package de.digitalcollections.iiif.demo.config;

import de.digitalcollections.iiif.hymir.config.SpringConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan(
    basePackages = {
      "de.digitalcollections.iiif.hymir.image",
      "de.digitalcollections.iiif.hymir.presentation"
    })
@Configuration
@Import({SpringConfig.class})
public class SpringConfigDemo {}
