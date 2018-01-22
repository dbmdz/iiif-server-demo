package de.digitalcollections.iiif.demo.service;

import de.digitalcollections.iiif.demo.repository.DemoPresentationRepositoryImpl;
import de.digitalcollections.iiif.hymir.presentation.business.PresentationServiceImpl;
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
