## Spring Web Api Versions

https://docs.spring.io/spring-framework/reference/7.0-SNAPSHOT/web/webmvc/mvc-config/api-version.html

First step: use query parameters;
  no default version
  no pathMatch prefix


for mediatype parameters:
The useMediaTypeParameter method is used to configure whether API versioning should be enabled and, if so, whether requests must include an API version parameter in their media type, according to Spring Framework documentation. This allows you to specify that API versions should be indicated within the Content-Type or Accept headers, rather than using a separate query parameter or path segment.
Here's a more detailed explanation:
API Versioning:
In many applications, especially those with evolving APIs, versioning is crucial to maintain compatibility when introducing changes.
Media Type Parameter:
Instead of using separate URL parameters (e.g., /api/v2/resource) or query parameters (e.g., /api/resource?version=2), the useMediaTypeParameter method allows you to embed version information directly into the media type.
Example:
A request might include a Content-Type header like application/json;version=2 or an Accept header like application/vnd.example.v2+json.
ApiVersionConfigurer:
This class is part of Spring's configuration mechanism for handling API versions in a web application, according to Spring Framework documentation.
compatibleMediaType and paramName:
The method typically takes a MediaType object (representing the base media type like application/json) and the name of the parameter to use for versioning (e.g., "version") as arguments.