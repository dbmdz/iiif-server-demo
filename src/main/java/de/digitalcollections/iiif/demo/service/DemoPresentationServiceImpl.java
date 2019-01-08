package de.digitalcollections.iiif.demo.service;

import de.digitalcollections.iiif.demo.repository.DemoPresentationRepositoryImpl;
import de.digitalcollections.iiif.hymir.presentation.backend.api.PresentationRepository;
import de.digitalcollections.iiif.hymir.presentation.business.PresentationServiceImpl;
import de.digitalcollections.iiif.hymir.presentation.business.api.PresentationSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class DemoPresentationServiceImpl extends PresentationServiceImpl {

  @Autowired
  private DemoPresentationRepositoryImpl demoPresentationRepository;

  public DemoPresentationServiceImpl(PresentationRepository presentationRepository, @Autowired(required = false) PresentationSecurityService presentationSecurityService) {
    super(presentationRepository, presentationSecurityService);
  }

  public void setServerUrl(String serverUrl) {
    demoPresentationRepository.setServerUrl(serverUrl);
  }

}
