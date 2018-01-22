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
      String contextPath = request.getContextPath();
      String requestUri = request.getRequestURI();
      String serverUrl = retrieveServerUrl(requestUrl, requestUri, contextPath);
      demoPresentationServiceImpl.setServerUrl(serverUrl);
    }
    response.addHeader("Access-Control-Allow-Origin", "*");
    return true;
  }

  public String retrieveServerUrl(String requestUrl, String requestUri, String contextPath) {
    String requestUriWithoutContextPath = requestUri.substring(contextPath.length());
    String serverUrl = requestUrl.substring(0, requestUrl.indexOf(requestUriWithoutContextPath));
    return serverUrl;
  }
}
