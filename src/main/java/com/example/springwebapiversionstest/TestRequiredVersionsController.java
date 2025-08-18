package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@Profile("requestHeaderRequiredVersions")
@RequestMapping("/requiredVersions")
class TestRequiredVersionsController {

    @GetMapping(version = "1.0.0")
    public String testV100() {
        return "test V1.0.0";
    }
    @GetMapping(version = "2.0.0")
    public String testV200() {
        return "test V2.0.0";
    }
    @GetMapping("/test1")
    public String noVersion() {
        return "test1 no explicit version";
    }
    @GetMapping(path="/test1", version = "1.5.0")
    public String test1V150() {
        return "test V1.5.0";
    }
}
