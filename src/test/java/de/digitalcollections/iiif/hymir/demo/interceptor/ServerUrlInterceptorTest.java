package de.digitalcollections.iiif.hymir.demo.interceptor;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ServerUrlInterceptorTest {

  private ServerUrlInterceptor interceptor;

  @Before
  public void setUp() {
    interceptor = new ServerUrlInterceptor();
  }

  @Test
  public void testRetrieveServerUrl() {
    String requestUrl = "http://localhost:8080/presentation/v2/12345/manifest";
    String requestUri = "/presentation/v2/12345/manifest";
    String contextPath = "";
    String expectedServerUrl = "http://localhost:8080";
    String resultingServerUrl = interceptor.retrieveServerUrl(requestUrl, requestUri, contextPath);
    assertThat(resultingServerUrl).isEqualTo(expectedServerUrl);

    requestUrl = "http://localhost:8080/iiif/presentation/v2/12345/manifest";
    requestUri = "/iiif/presentation/v2/12345/manifest";
    contextPath = "/iiif";
    expectedServerUrl = "http://localhost:8080/iiif";
    resultingServerUrl = interceptor.retrieveServerUrl(requestUrl, requestUri, contextPath);
    assertThat(resultingServerUrl).isEqualTo(expectedServerUrl);

    requestUrl = "http://localhost/iiif/presentation/v2/12345/manifest";
    requestUri = "/iiif/presentation/v2/12345/manifest";
    contextPath = "/iiif";
    expectedServerUrl = "http://localhost/iiif";
    resultingServerUrl = interceptor.retrieveServerUrl(requestUrl, requestUri, contextPath);
    assertThat(resultingServerUrl).isEqualTo(expectedServerUrl);

    requestUrl = "http://www.example.org/iiif/presentation/v2/12345/manifest";
    requestUri = "/iiif/presentation/v2/12345/manifest";
    contextPath = "/iiif";
    expectedServerUrl = "http://www.example.org/iiif";
    resultingServerUrl = interceptor.retrieveServerUrl(requestUrl, requestUri, contextPath);
    assertThat(resultingServerUrl).isEqualTo(expectedServerUrl);
  }
}
