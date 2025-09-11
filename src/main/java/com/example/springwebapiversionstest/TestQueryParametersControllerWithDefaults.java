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
        return "explicit version same as defaultVersion (1.0.0)";
    }

    @GetMapping(version = "2.0.0")
    public String otherVersion() {
        return "other explicit Version (2.0.0)";
    }

    @GetMapping("/test1")
    public String noExplicitVersion1() {
        return "test1 no explicit Version";
    }

    @GetMapping(path = "/test2", version = "1.0.0")
    public String test2defaultVersion() {
        return "test2: explicit version same as defaultVersion (1.0.0)";
    }

    @GetMapping(path = "/test2", version = "2.0.0")
    public String test2otherVersion() {
        return "test2: other explicit Version (2.0.0)";
    }
}
