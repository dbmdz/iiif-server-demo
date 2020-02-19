package de.digitalcollections.iiif.demo.config;

import de.digitalcollections.iiif.hymir.config.SpringConfigSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SpringConfigSecurity.class)
public class SpringConfigSecurityDemo {}
