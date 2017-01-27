package de.digitalcollections.iiif.serverdemo.repository;

import de.digitalcollections.iiif.presentation.backend.api.exceptions.NotFoundException;
import de.digitalcollections.iiif.presentation.backend.impl.repository.v2.PresentationRepositoryImpl;
import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * IIIF Presentation repository for all manifests.
 */
@Primary
@Repository
public class DemoPresentationRepositoryImpl extends PresentationRepositoryImpl {

  private static final Logger LOGGER = LoggerFactory.getLogger(DemoPresentationRepositoryImpl.class);

  private final String serverUrlPlaceholder = "http://localhost:8080";
  private String serverUrl;

  @Override
  public String getManifestJson(URI manifestUri) throws NotFoundException {
    String json = super.getManifestJson(manifestUri);
    json = replaceUrlEndpoints(json);
    LOGGER.debug("manifest json: " + json);
    return json;
  }

  public void setServerUrl(String serverUrl) {
    this.serverUrl = serverUrl;
  }

  private String replaceUrlEndpoints(String json) {
    json = json.replaceAll(this.serverUrlPlaceholder, this.serverUrl);
    LOGGER.info("replaced all occurrences of the placeholder {} with the application url {}", this.serverUrlPlaceholder, this.serverUrl);
    return json;
  }

}
