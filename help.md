## Spring Web Api Versions

https://docs.spring.io/spring-framework/reference/7.0-SNAPSHOT/web/webmvc/mvc-config/api-version.html

TODO:
- test classes for all cases;
- check what's wrong with mediatype case
- multiple configurers tests



Cases:
- all kinds of supported configurations:
    - path segments (with path prefix, w/o path prefix)
    - query parameters
    - request headers
    - mediatypes
- default versions (configurer.setDefaultVersion)
- check supported versions (configurer.addSupportedVersions)
- check required versions (configurer.setVersionRequired(true))
- check multiple configurers in the same class
- check multiple configurations with different supported versions in the different classes
   


