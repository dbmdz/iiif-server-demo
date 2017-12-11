# IIIF Server Demo

[![Javadocs](http://javadoc.io/badge/de.digitalcollections/iiif-server-demo.svg)](http://javadoc.io/doc/de.digitalcollections/iiif-server-demo)
[![Build Status](https://travis-ci.org/dbmdz/iiif-server-demo.svg?branch=master)](https://travis-ci.org/dbmdz/iiif-server-demo)
[![Codacy](https://api.codacy.com/project/badge/Grade/6af6b5a2fa6d4883a1a270ceda2680bc)](https://www.codacy.com/app/dbmdz/iiif-server-demo_2?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=dbmdz/iiif-server-demo&amp;utm_campaign=Badge_Grade)
[![Codebeat](https://codebeat.co/badges/5260f53b-76bd-4e49-a4c1-dd8a729b3d44)](https://codebeat.co/projects/github-com-dbmdz-iiif-server-demo-master)
[![Codecov](https://codecov.io/gh/dbmdz/iiif-server-demo/branch/master/graph/badge.svg)](https://codecov.io/gh/dbmdz/iiif-server-demo)
[![MIT License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![GitHub release](https://img.shields.io/github/release/dbmdz/iiif-server-demo.svg?maxAge=2592000)](https://github.com/dbmdz/iiif-server-demo/releases)
[![Maven Central](https://img.shields.io/maven-central/v/de.digitalcollections/iiif-server-demo.svg?maxAge=2592000)](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22iiif-server-demo%22)

A standalone IIIF server demonstrating the use of [IIIF Image API Java Libraries](https://github.com/dbmdz/iiif-image-api "IIIF Image API Java Libraries") and [IIIF Presentation API Java Libraries](https://github.com/dbmdz/iiif-presentation-api "IIIF Presentation API Java Libraries") (Java implementations of the [IIIF specifications](http://iiif.io/technical-details/ "IIIF specifications")) and annotations stored in the local storage of the browser.

## Prerequisites

* Java 8: You will need the [Java Runtime Environment (JRE) version 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html) or higher. At a command line, check your Java version with "java -version".

## Run Demo Server

- Download iiif-server-demo-3.0.0.jar from [Releases on GitHub](https://github.com/dbmdz/iiif-server-demo/releases)
- Start server: `$ java -jar iiif-server-demo-3.0.0.jar`
- View Homepage: [http://localhost:8080/iiif](http://localhost:8080/iiif)

## Build from source and run it

```shell
$ mvn package && java -jar target/iiif-server-demo-3.0.0.jar
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
