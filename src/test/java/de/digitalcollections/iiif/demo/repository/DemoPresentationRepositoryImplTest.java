package de.digitalcollections.iiif.demo.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoPresentationRepositoryImplTest {

  private String jsonStringtoModify;
  private DemoPresentationRepositoryImpl repository;

  @BeforeEach
  public void setUp() {
    jsonStringtoModify = "{\"@id\":\"http://localhost:8080/presentation/v2/bsb00026283/manifest\"}";
    repository = new DemoPresentationRepositoryImpl();
  }

  @Test
  public void testReplaceUrlEndpointsWithoutContext() throws Exception {
    repository.setServerUrl("http://localhost:8080");
    String result = repository.replaceUrlEndpoints(jsonStringtoModify);
    assertThat(result).isEqualTo(jsonStringtoModify);
  }

  @Test
  public void testReplaceUrlEndpointsWithContext() throws Exception {
    repository.setServerUrl("http://localhost:8080/demo");
    String result = repository.replaceUrlEndpoints(jsonStringtoModify);
    String expectedResult = "{\"@id\":\"http://localhost:8080/demo/presentation/v2/bsb00026283/manifest\"}";
    assertThat(result).isEqualTo(expectedResult);
  }

  @Test
  public void testReplaceUrlEndpointsWithOtherHost() throws Exception {
    repository.setServerUrl("http://virtualbox:8080/demo");
    String result = repository.replaceUrlEndpoints(jsonStringtoModify);
    String expectedResult = "{\"@id\":\"http://virtualbox:8080/demo/presentation/v2/bsb00026283/manifest\"}";
    assertThat(result).isEqualTo(expectedResult);
  }
}
