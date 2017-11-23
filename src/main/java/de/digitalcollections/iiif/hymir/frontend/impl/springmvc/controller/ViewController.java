package de.digitalcollections.iiif.hymir.frontend.impl.springmvc.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Demo controller for serving IIIF services on demo data.
 */
@Controller
public class ViewController {

  @Autowired
  @Value("#{iiifVersions}")
  private Map<String, String> iiifVersions;

  @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
  public String getHomepage(Model model) {
    model.addAttribute("active", "home");
    return "index";
  }

  @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
  public String getAbout(Model model) {
    model.addAttribute("active", "about");
    return "about";
  }

  /* Image API */
  @RequestMapping(value = {"/image-request-url.html"}, method = RequestMethod.GET)
  public String getImageRequestUrlDemo(Model model, HttpServletRequest request) {
    model.addAttribute("active", "demos");
    String baseUrl = String.format("%s://%s:%d", request.getScheme(), request.getServerName(), request.getServerPort());
    model.addAttribute("baseUrl", baseUrl);
    return "image-api/view_image-request-url";
  }

  @RequestMapping(value = {"/image-info-url.html"}, method = RequestMethod.GET)
  public String getImageInfoUrlDemo(Model model, HttpServletRequest request) {
    model.addAttribute("active", "demos");
    String baseUrl = String.format("%s://%s:%d", request.getScheme(), request.getServerName(), request.getServerPort());
    model.addAttribute("baseUrl", baseUrl);
    return "image-api/view_image-info-url";
  }

  @RequestMapping(value = "/{identifier}/view_image.html", method = RequestMethod.GET)
  public String getOpenSeadragonPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("infoUrl", "/image/v2/" + identifier + "/info.json");
    return "openseadragon/view_openseadragon";
  }

  @RequestMapping(value = "/{identifier}/view_leaflet-image.html", method = RequestMethod.GET)
  public String getLeafletImageViewerPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("infoUrl", "/image/v2/" + identifier + "/info.json");
    return "leaflet/view_leaflet-image";
  }

  /* Presentation API */
  @RequestMapping(value = {"/{identifier}/presentation-manifest-url.html"},
          method = RequestMethod.GET)
  public String getPresentationManifestUrlDemo(@PathVariable String identifier, Model model, HttpServletRequest request) {
    model.addAttribute("active", "demos");
    String baseUrl = String.format("%s://%s:%d", request.getScheme(), request.getServerName(), request.getServerPort());
    model.addAttribute("baseUrl", baseUrl);
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "presentation-api/view_presentation-manifest-url";
  }

  @RequestMapping(value = {"/{name}/presentation-collection-url.html"},
          method = RequestMethod.GET)
  public String getPresentationCollectionUrlDemo(@PathVariable String name, Model model, HttpServletRequest request) {
    model.addAttribute("active", "demos");
    String baseUrl = String.format("%s://%s:%d", request.getScheme(), request.getServerName(), request.getServerPort());
    model.addAttribute("baseUrl", baseUrl);
    model.addAttribute("manifestId", "/presentation/v2/collection/" + name);
    return "presentation-api/view_presentation-collection-url";
  }

  @RequestMapping(value = "/{identifier}/view_mirador.html", method = RequestMethod.GET)
  public String getMiradorPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "mirador/view_mirador";
  }

  @RequestMapping(value = "/{identifier}/view_universal.html", method = RequestMethod.GET)
  public String getUniversalViewerPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "universalviewer/view_universal";
  }

  @RequestMapping(value = "/{identifier}/view_leaflet-presentation.html", method = RequestMethod.GET)
  public String getLeafletManifestViewerPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "leaflet/view_leaflet-presentation";
  }

  /* Mirador with plugins */
  @RequestMapping(value = "/{identifier}/view_mirador_canvaslink.html", method = RequestMethod.GET)
  public String getMiradorCanvasLinkPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "mirador/view_mirador_canvaslink";
  }

  @RequestMapping(value = "/{identifier}/view_mirador_imagecropper.html", method = RequestMethod.GET)
  public String getMiradorImageCropperPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "mirador/view_mirador_imagecropper";
  }

  @RequestMapping(value = "/{identifier}/view_mirador_keyboardnavigation.html", method = RequestMethod.GET)
  public String getMiradorKeyboardNavigationPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "mirador/view_mirador_keyboardnavigation";
  }

  @RequestMapping(value = "/{identifier}/view_mirador_manifestbutton.html", method = RequestMethod.GET)
  public String getMiradorManifestButtonPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "mirador/view_mirador_manifestbutton";
  }

  @RequestMapping(value = "/{identifier}/view_mirador_multipagenavigation.html", method = RequestMethod.GET)
  public String getMiradorMultiPageNavigationPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "mirador/view_mirador_multipagenavigation";
  }

  @RequestMapping(value = "/{identifier}/view_mirador_physicalruler.html", method = RequestMethod.GET)
  public String getMiradorPhysicalRulerPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "mirador/view_mirador_physicalruler";
  }

  @RequestMapping(value = "/{identifier}/view_mirador_viewfromurl.html", method = RequestMethod.GET)
  public String getMiradorViewFromUrlPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "mirador/view_mirador_viewfromurl";
  }

  @ModelAttribute("iiifVersions")
  protected Map<String, String> getIIIFVersions() {
    return iiifVersions;
  }

}
