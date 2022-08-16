package de.digitalcollections.iiif.demo.frontend;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Map;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.webjars.WebJarAssetLocator;

@ControllerAdvice
public class GlobalControllerAdvice {

  private final Map<String, String> webjarVersions;

  public GlobalControllerAdvice() {
    WebJarAssetLocator locator = new WebJarAssetLocator();
    this.webjarVersions = locator.getWebJars();
  }

  @SuppressFBWarnings(
      value = "EI_EXPOSE_REP",
      justification = "Value is only used by the Spring framework")
  /** Adds the webjar versions read from yaml files as global model attribute. */
  @ModelAttribute("webjarVersions")
  public Map<String, String> getWebjarVersions() {
    return webjarVersions;
  }
}
