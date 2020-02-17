package de.digitalcollections.iiif.demo.util;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/** Helper class that aids in retrieving the base url */
@Component
public class UrlHelper {

  public String getBaseUrl(HttpServletRequest request) {
    String scheme = request.getHeader("X-Forwarded-Proto");
    if (scheme == null) {
      scheme = request.getScheme();
    }

    String host = request.getHeader("X-Forwarded-Host");
    if (host == null) {
      host = request.getHeader("Host");
    }
    if (host == null) {
      host = request.getRemoteHost();
    }

    String baseUrl = String.format("%s://%s", scheme, host);
    if (!request.getContextPath().isEmpty()) {
      baseUrl += request.getContextPath();
    }
    return baseUrl;
  }
}
