package de.digitalcollections.iiif.hymir.demo.repository;

import de.digitalcollections.iiif.hymir.model.api.exception.ResolvingException;
import de.digitalcollections.iiif.hymir.presentation.backend.impl.repository.v2.PresentationRepositoryImpl;
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

  private String serverUrlPlaceholder = "http://localhost:8080";
  private String serverUrl;

  @Override
  public String getResourceJson(URI manifestUri) throws ResolvingException {
    String json = super.getResourceJson(manifestUri);
    json = replaceUrlEndpoints(json);
    LOGGER.debug("manifest json: " + json);
    return json;
  }

  public void setServerUrl(String serverUrl) {
    this.serverUrl = serverUrl;
  }

  public String replaceUrlEndpoints(String json) {
    if (!this.serverUrlPlaceholder.equals(this.serverUrl)) {
      json = json.replaceAll(this.serverUrlPlaceholder, this.serverUrl);
      LOGGER.info("replaced all occurrences of the placeholder {} with the application url {}",
              this.serverUrlPlaceholder, this.serverUrl);
    }
    return json;
  }

}
