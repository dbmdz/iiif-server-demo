package de.digitalcollections.iiif.serverdemo.interceptor;

import de.digitalcollections.iiif.hymir.demo.interceptor.ServerUrlInterceptor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ServerUrlInterceptorTest {

  ServerUrlInterceptor instance = new ServerUrlInterceptor();

  @Test
  public void testRetrieveServerUrl() {
    String requestUrl = "http://localhost:8080/presentation/v2/12345/manifest";
    String requestUri = "/presentation/v2/12345/manifest";
    String contextPath = "";
    String expectedServerUrl = "http://localhost:8080";
    String resultingServerUrl = instance.retrieveServerUrl(requestUrl, requestUri, contextPath);
    assertEquals(expectedServerUrl, resultingServerUrl);

    requestUrl = "http://localhost:8080/iiif/presentation/v2/12345/manifest";
    requestUri = "/iiif/presentation/v2/12345/manifest";
    contextPath = "/iiif";
    expectedServerUrl = "http://localhost:8080/iiif";
    resultingServerUrl = instance.retrieveServerUrl(requestUrl, requestUri, contextPath);
    assertEquals(expectedServerUrl, resultingServerUrl);

    requestUrl = "http://localhost/iiif/presentation/v2/12345/manifest";
    requestUri = "/iiif/presentation/v2/12345/manifest";
    contextPath = "/iiif";
    expectedServerUrl = "http://localhost/iiif";
    resultingServerUrl = instance.retrieveServerUrl(requestUrl, requestUri, contextPath);
    assertEquals(expectedServerUrl, resultingServerUrl);

    requestUrl = "http://www.example.org/iiif/presentation/v2/12345/manifest";
    requestUri = "/iiif/presentation/v2/12345/manifest";
    contextPath = "/iiif";
    expectedServerUrl = "http://www.example.org/iiif";
    resultingServerUrl = instance.retrieveServerUrl(requestUrl, requestUri, contextPath);
    assertEquals(expectedServerUrl, resultingServerUrl);
  }
}
