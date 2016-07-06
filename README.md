# IIIF Server Demo
A standalone IIIF server demonstrating the use of IIIF Image API and IIIF Presentation API Libraries.

## Build and run it

    $ mvn package && java -jar target/iiif-server-demo.jar

## Usage

Start Demo:

    java -jar iiif-server-demo.jar

View description and URL-Tester:

    http://localhost:8080/

View zoomable image demo (using OpenSeadragon 2.0.0 viewer):

    http://localhost:8080/demo/bsb00026283_00041/view.html

## About the Demo's architecture

The Demo IIIF server uses Spring Boot serving a Spring MVC + Thymeleaf-Templates webapplication.<br/>
(See <a href="https://spring.io/guides/gs/spring-boot/">https://spring.io/guides/gs/spring-boot/</a>.)

Images are resolved by the demo specific classpath-access and currently only can serve the image with the identifier "bsb00026283_00041" (only packaged image in the demo). But you also could extend the resolvers for HTTP- or File-Protocol in the properties-files.

## License

The demo image is part of the "Ottheinrich-Bibel" page "Einzug in Jerusalem" presented by the Bavarian State Library here: <a href="http://daten.digitale-sammlungen.de/bsb00026283/image_41">http://daten.digitale-sammlungen.de/bsb00026283/image_41</a>.
It is under the "Attribution-NonCommercial-ShareAlike 4.0 International (CC BY-NC-SA 4.0)"-License (see <a href="http://creativecommons.org/licenses/by-nc-sa/4.0/">http://creativecommons.org/licenses/by-nc-sa/4.0/</a>)