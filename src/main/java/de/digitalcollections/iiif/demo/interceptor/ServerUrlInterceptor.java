package de.digitalcollections.iiif.demo.interceptor;

import de.digitalcollections.iiif.demo.service.DemoPresentationServiceImpl;
import de.digitalcollections.iiif.demo.util.UrlHelper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class ServerUrlInterceptor extends HandlerInterceptorAdapter {

  @Autowired
  private DemoPresentationServiceImpl demoPresentationServiceImpl;

  @Autowired
  private UrlHelper urlHelper;

  // before the actual handler will be executed
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String requestUrl = request.getRequestURL().toString();
    if (requestUrl.endsWith("/manifest") || requestUrl.matches(".*?/canvas/.*?/view$")) {
      String serverUrl = urlHelper.getBaseUrl(request);
      demoPresentationServiceImpl.setServerUrl(serverUrl);
    }
    response.addHeader("Access-Control-Allow-Origin", "*");
    return true;
  }
}
