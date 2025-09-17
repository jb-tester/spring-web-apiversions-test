package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// note the false-positive warning about not consumed `version` path variable
@RestController
@Profile("pathSegmentNoPrefix")
@RequestMapping("/pathSegments/{version}")
class TestPathSegmentsNoPrefixController {

    @GetMapping(version ="1.1")
    public String getV11(@PathVariable String version) {
        return "pathSegments - V1.1; {version} = " + version;
    }
    @GetMapping(version ="1.2")
    public String getV12() {
        return "pathSegments - V1.2";
    }
    @GetMapping
    public String getNoVersion() {
        return "pathSegments - no version";
    }
    @GetMapping(version = "1.4+")
    public String getV4Plus() {
        return "pathSegments - V1.4+";
    }
}
