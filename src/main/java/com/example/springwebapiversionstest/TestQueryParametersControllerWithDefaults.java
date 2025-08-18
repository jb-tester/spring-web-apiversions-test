package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("queryParamWithDefaults")
@RequestMapping("/queryParamsWithDefault")
public class TestQueryParametersControllerWithDefaults {

    @GetMapping()
    public String noExplicitVersion() {
        return "no explicit Version";
    }

    @GetMapping(version = "1.0.0")
    public String defaultVersion() {
        return "defaultVersion";
    }

    @GetMapping(version = "2.0.0")
    public String otherVersion() {
        return "otherVersion";
    }

    @GetMapping("/test1")
    public String noExplicitVersion1() {
        return "no explicit Version1";
    }
}
