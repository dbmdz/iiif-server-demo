package de.digitalcollections.iiif.serverdemo.interceptor;

import de.digitalcollections.iiif.serverdemo.service.DemoPresentationServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ServerUrlInterceptor extends HandlerInterceptorAdapter {

  @Autowired
  DemoPresentationServiceImpl demoPresentationServiceImpl;

  //before the actual handler will be executed
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String requestUrl = request.getRequestURL().toString();
    if (requestUrl.endsWith("/manifest")) {
      String contextPath = request.getContextPath();
      String requestUri = request.getRequestURI();
      String serverUrl = retrieveServerUrl(requestUrl, requestUri, contextPath);
      demoPresentationServiceImpl.setServerUrl(serverUrl);
    }
    return true;
  }

  protected String retrieveServerUrl(String requestUrl, String requestUri, String contextPath) {
    String requestUriWithoutContextPath = requestUri.substring(contextPath.length());
    String serverUrl = requestUrl.substring(0, requestUrl.indexOf(requestUriWithoutContextPath));
    return serverUrl;
  }
}