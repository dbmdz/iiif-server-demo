package de.digitalcollections.iiif.serverdemo.service;

import de.digitalcollections.iiif.presentation.business.impl.service.v2.PresentationServiceImpl;
import de.digitalcollections.iiif.serverdemo.repository.DemoPresentationRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class DemoPresentationServiceImpl extends PresentationServiceImpl {

  private static final Logger LOGGER = LoggerFactory.getLogger(DemoPresentationServiceImpl.class);

  @Autowired
  private DemoPresentationRepositoryImpl demoPresentationRepository;
  
  public void setServerUrl(String serverUrl) {
    demoPresentationRepository.setServerUrl(serverUrl);
  }

}
