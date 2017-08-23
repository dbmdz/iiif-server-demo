/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.digitalcollections.iiif.serverdemo.repository;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoPresentationRepositoryImplTest {

  DemoPresentationRepositoryImpl instance = new DemoPresentationRepositoryImpl();
  String jsonStringtoModify = "{\"@id\":\"http://localhost:8080/presentation/v2/bsb00026283/manifest\"}";

  @Test
  public void testReplaceUrlEndpointsWithoutContext() throws Exception {
    instance.setServerUrl("http://localhost:8080");
    String result = instance.replaceUrlEndpoints(jsonStringtoModify);
    assertThat(result).isEqualTo(jsonStringtoModify);
  }

  @Test
  public void testReplaceUrlEndpointsWithContext() throws Exception {
    instance.setServerUrl("http://localhost:8080/demo");
    String result = instance.replaceUrlEndpoints(jsonStringtoModify);
    String expectedResult = "{\"@id\":\"http://localhost:8080/demo/presentation/v2/bsb00026283/manifest\"}";
    assertThat(result).isEqualTo(expectedResult);
  }

  @Test
  public void testReplaceUrlEndpointsWithOtherHost() throws Exception {
    instance.setServerUrl("http://virtualbox:8080/demo");
    String result = instance.replaceUrlEndpoints(jsonStringtoModify);
    String expectedResult = "{\"@id\":\"http://virtualbox:8080/demo/presentation/v2/bsb00026283/manifest\"}";
    assertThat(result).isEqualTo(expectedResult);
  }

}
