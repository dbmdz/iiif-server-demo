# IIIF Server Demo

[![Javadocs](https://javadoc.io/badge/de.digitalcollections/iiif-server-demo.svg)](https://javadoc.io/doc/de.digitalcollections/iiif-server-demo)
[![Build Status](https://img.shields.io/travis/dbmdz/iiif-server-demo/master.svg)](https://travis-ci.org/dbmdz/iiif-server-demo)
[![Codecov](https://img.shields.io/codecov/c/github/dbmdz/iiif-server-demo/master.svg)](https://codecov.io/gh/dbmdz/iiif-server-demo)
[![License](https://img.shields.io/github/license/dbmdz/iiif-server-demo.svg)](LICENSE)
[![GitHub release](https://img.shields.io/github/release/dbmdz/iiif-server-demo.svg)](https://github.com/dbmdz/iiif-server-demo/releases)
[![Maven Central](https://img.shields.io/maven-central/v/de.digitalcollections/iiif-server-demo.svg)](https://search.maven.org/search?q=a:iiif-server-demo)

A standalone IIIF server demonstrating the features of the IIIF Image API (http://iiif.io/api/image/2.1/) and the IIIF Presentation API (http://iiif.io/api/presentation/2.1/) and showcasing different IIIF viewers.

## Prerequisites

* Java 8: You will need the [Java Runtime Environment (JRE) version 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html) or higher. At a command line, check your Java version with "java -version".

## Run Demo Server

- Download `iiif-server-demo-<version>-exec.jar` from [Releases on GitHub](https://github.com/dbmdz/iiif-server-demo/releases)
- Start server: `$ java -jar iiif-server-demo-<version>-exec.jar`
- View Homepage: [http://localhost:8080/iiif](http://localhost:8080/iiif)

## Build from source and run it

```shell
$ mvn package && java -jar target/iiif-server-demo-<version>-exec.jar
```

## Screenshots

IIIF Image API URL Demo:

![Image API URL Demo](./doc/images/screenshot-image-api-url.png)

OpenSeadragon zoom viewer Demo:

![OpenSeadragon zoom viewer Demo](./doc/images/screenshot-openseadragon.png)

Mirador presentation viewer Demo:

![Mirador presentation viewer Demo](./doc/images/screenshot-mirador.png)

## About the Demo's architecture

The Demo IIIF server uses Spring Boot serving a Spring MVC + Thymeleaf-Templates webapplication.<br/>
(See <a href="https://spring.io/guides/gs/spring-boot/">https://spring.io/guides/gs/spring-boot/</a>.)

Images are resolved by the demo specific classpath-access and currently only can serve the images with the identifiers "bsb00026283_0004x" (only packaged images in the demo). But you also could extend the resolvers for HTTP- or File-Protocol in the config-file "multiPatternResolving-PROD.yml".

## License of images

The demo images are part of the "Ottheinrich-Bibel" presented by the Bavarian State Library <a href="https://api.digitale-sammlungen.de/iiif/presentation/v2/bsb00026283/canvas/41/view">here</a>.
They are under the "Attribution-NonCommercial-ShareAlike 4.0 International (CC BY-NC-SA 4.0)"-License (see <a href="http://creativecommons.org/licenses/by-nc-sa/4.0/">http://creativecommons.org/licenses/by-nc-sa/4.0/</a>).
