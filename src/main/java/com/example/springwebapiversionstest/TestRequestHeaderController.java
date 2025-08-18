package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Profile("requestHeader")
@RequestMapping("/requestHeader")
public class TestRequestHeaderController {

    // looks like we should show the attempts to declare the header explicitly in the mapping method definition as an error:

    // this mapping can be called only with no Version-header header provided
    @GetMapping
    public String tryExplicitHeaderWithDefaultValue(@RequestHeader(value = "Version-header", defaultValue = "1.0.0") String version) {

        return "version specified as explicit header - " + version;
    }
    // this mapping calling will fail with "Invalid API version" if we provide any version header to the request
    // and with "Required header 'Version-header' is not present." if no header is provided
    @GetMapping("/test1")
    public String tryExplicitHeaderWithoutDefaultValue(@RequestHeader(value = "Version-header") String version) {

        return "version specified as explicit header with no defaults - " + version;
    }


    @GetMapping(version = "1.2.0")
    public String testVersion12() {

        return "version 1.2.0";
    }
    @GetMapping(version = "1.3+")
    public String testVersion13() {

        return "version 1.3+";
    }
   // for http request generation testing
    @GetMapping(path = "/test2", version = "1.2.0")
    public String withDifferentRequestHeaders(@RequestHeader(value = "rh1") String rh1, @RequestHeader(value = "rh2") String rh2) {

        return "version 120 with diff req headers: " + rh1 + " " + rh2;
    }

}
