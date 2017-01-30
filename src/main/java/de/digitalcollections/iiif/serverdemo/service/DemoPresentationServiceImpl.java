package de.digitalcollections.iiif.serverdemo.service;

import de.digitalcollections.iiif.presentation.business.impl.service.v2.PresentationServiceImpl;
import de.digitalcollections.iiif.serverdemo.repository.DemoPresentationRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class DemoPresentationServiceImpl extends PresentationServiceImpl {

  @Autowired
  private DemoPresentationRepositoryImpl demoPresentationRepository;
  
  public void setServerUrl(String serverUrl) {
    demoPresentationRepository.setServerUrl(serverUrl);
  }

}
