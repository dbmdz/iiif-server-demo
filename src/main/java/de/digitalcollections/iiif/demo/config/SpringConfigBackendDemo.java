package de.digitalcollections.iiif.demo.config;

import de.digitalcollections.iiif.hymir.config.SpringConfigBackendImage;
import de.digitalcollections.iiif.hymir.config.SpringConfigBackendPresentation;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SpringConfigBackendImage.class, SpringConfigBackendPresentation.class})
public class SpringConfigBackendDemo {}
