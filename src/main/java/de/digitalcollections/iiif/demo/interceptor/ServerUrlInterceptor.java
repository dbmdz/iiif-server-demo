package de.digitalcollections.iiif.demo.interceptor;

import de.digitalcollections.iiif.demo.service.DemoPresentationServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class ServerUrlInterceptor extends HandlerInterceptorAdapter {

  @Autowired
  private DemoPresentationServiceImpl demoPresentationServiceImpl;

  // before the actual handler will be executed
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String requestUrl = request.getRequestURL().toString();
    if (requestUrl.endsWith("/manifest") || requestUrl.matches(".*?/canvas/.*?/view$")) {
      String serverUrl = getBaseUrl(request);
      demoPresentationServiceImpl.setServerUrl(serverUrl);
    }
    response.addHeader("Access-Control-Allow-Origin", "*");
    return true;
  }

  private String getBaseUrl(HttpServletRequest request) {
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
