## Spring Web Api Versions

https://docs.spring.io/spring-framework/reference/7.0-SNAPSHOT/web/webmvc/mvc-config/api-version.html

Work in progress...

TODO:
- test classes for all cases;
- multiple configurers tests



Cases:
 - all kinds of supported configurations with corresponding HTTP Requests collections:
     - [x] path segments (with path prefix, w/o path prefix)
     - [x] query parameters
     - [x] request headers
     - [x] mediatypes
 - [x] default versions (configurer.setDefaultVersion) 
 - [x] check supported versions (configurer.addSupportedVersions)
 - [x] check required versions (configurer.setVersionRequired(true))
 - [ ] check multiple configurers in the same class
 - [ ] check multiple configurations with different supported versions in the different classes
 - [ ] rest clients
 - [ ] mockmvc tests

Features:
 - HTTP Requests generation
 - configuration validation ('version' using w/o configuration)
 - the versions format validation in mappings
 - the duplicated versions checking in mappings
 - inspection for requiredVersions plus defaultVersion
 - supported versions checking?
 - old-style versioning (explicit `@RequestParam` or `@RequestHeader` passing for versioning) with configured versioning
 - completion for headers/params in tests and HTTP client
 - navigation to matching endpoints!!!!
 - correct representation in Endpoints/Structure view
 - Swagger generation (correct versions)
 - matching details in Debugger?


