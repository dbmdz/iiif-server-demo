package de.digitalcollections.iiif.demo.frontend;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ViewControllerTest {

  @Autowired private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void shouldGetHomepage() throws Exception {
    ResultActions perform = mockMvc.perform(get("/").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("home")));
  }

  @Test
  public void shouldGetAbout() throws Exception {
    ResultActions perform = mockMvc.perform(get("/about").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("about")));
  }

  @Test
  public void shouldGetImageRequestUrlDemo() throws Exception {
    ResultActions perform =
        mockMvc.perform(get("/image-request-url.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("demos")));
  }

  @Test
  public void shouldGetImageInfoUrlDemo() throws Exception {
    ResultActions perform =
        mockMvc.perform(get("/image-info-url.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("demos")));
  }

  @Test
  public void shouldGetOpenSeadragonPage() throws Exception {
    ResultActions perform =
        mockMvc.perform(get("/12345/view_image.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("demos")));
    perform.andExpect(model().attribute("infoUrl", is("/image/v2/12345/info.json")));
  }

  @Test
  public void shouldGetLeafletImageViewerPage() throws Exception {
    ResultActions perform =
        mockMvc.perform(get("/12345/view_leaflet-image.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("demos")));
    perform.andExpect(model().attribute("infoUrl", is("/image/v2/12345/info.json")));
  }

  @Test
  public void shouldGetPresentationManifestDemo() throws Exception {
    ResultActions perform =
        mockMvc.perform(get("/12345/presentation-manifest-url.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("demos")));
    perform.andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetCollectionManifestDemo() throws Exception {
    ResultActions perform =
        mockMvc.perform(get("/12345/presentation-collection-url.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("demos")));
    perform.andExpect(model().attribute("manifestId", is("/presentation/v2/collection/12345")));
  }

  @Test
  public void shouldGetMiradorPage() throws Exception {
    ResultActions perform =
        mockMvc.perform(get("/12345/view_mirador.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("demos")));
    perform.andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetTifyPage() throws Exception {
    ResultActions perform =
        mockMvc.perform(get("/12345/view_tify.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("demos")));
    perform.andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetUniversalViewerPage() throws Exception {
    ResultActions perform =
        mockMvc.perform(get("/12345/view_universal.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("demos")));
    perform.andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetLeafletManifestViewerPage() throws Exception {
    ResultActions perform =
        mockMvc.perform(get("/12345/view_leaflet-presentation.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("demos")));
    perform.andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetMiradorCanvasLinkPage() throws Exception {
    ResultActions perform =
        mockMvc.perform(get("/12345/view_mirador_canvaslink.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("demos")));
    perform.andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetMiradorImageCropperPage() throws Exception {
    ResultActions perform =
        mockMvc.perform(get("/12345/view_mirador_imagecropper.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("demos")));
    perform.andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetMiradorKeyboardNavigationPage() throws Exception {
    ResultActions perform =
        mockMvc.perform(
            get("/12345/view_mirador_keyboardnavigation.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("demos")));
    perform.andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetMiradorManifestButtonPage() throws Exception {
    ResultActions perform =
        mockMvc.perform(get("/12345/view_mirador_manifestbutton.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("demos")));
    perform.andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetMiradorMultiPageNavigationPage() throws Exception {
    ResultActions perform =
        mockMvc.perform(
            get("/12345/view_mirador_multipagenavigation.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("demos")));
    perform.andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetMiradorPyhsicalRulerPage() throws Exception {
    ResultActions perform =
        mockMvc.perform(get("/12345/view_mirador_physicalruler.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("demos")));
    perform.andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetMiradorViewFromUrlPage() throws Exception {
    ResultActions perform =
        mockMvc.perform(get("/12345/view_mirador_viewfromurl.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(status().isOk());
    perform.andExpect(model().attribute("active", is("demos")));
    perform.andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }
}
