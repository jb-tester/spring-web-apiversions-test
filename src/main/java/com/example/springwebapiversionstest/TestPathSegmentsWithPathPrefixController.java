package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@Profile("pathSegmentWithPathPrefix")
@RequestMapping("/pathSegments")
class TestPathSegmentsWithPathPrefixController {

    @GetMapping(version ="1.1")
    public String getV1() {
        return "pathSegments - V1";
    }
    @GetMapping(version ="1.2")
    public String getV2() {
        return "pathSegments - V2";
    }
    @GetMapping
    public String getNoVersion() {
        return "pathSegments - no version";
    }
    @GetMapping(version = "1.4+")
    public String getV4Plus() {
        return "pathSegments - V4+";
    }
}
