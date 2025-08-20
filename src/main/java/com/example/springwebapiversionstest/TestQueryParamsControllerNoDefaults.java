package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("queryParamNoDefaults")
@RequestMapping("/queryParamsNoDefaults")
class TestQueryParamsControllerNoDefaults {

    @GetMapping(version = "1.0.0")
    public String testExplicitlySpecifiedDefaultVersion() {
        return "test Explicitly Specified Version 1.0.0";
    }

    @GetMapping()
    public String testNoExplicitVersion() {
        return "test No Explicit Version";
    }

    @GetMapping(version = "1.1.1")
    public String testExplicitlySpecifiedVersion110() {
        return "test Explicitly Specified Version 1.1.1";
    }

    @GetMapping(version = "1.2+")
    public String testExplicitlySpecifiedVersion12Plus() {
        return "test Explicitly Specified Version 1.2+";
    }

    @GetMapping(path = "/test1", version = "0.0.1")
    public String test1ExplicitlySpecifiedVersion001() {
        return "test1_no_explicit_version";
    }
    @GetMapping(path = "/test1", version = "2.0.0")
    public String test1ExplicitlySpecifiedVersion200() {
        return "test1_2.0.0";
    }
    @GetMapping(path = "/test1", version = "3.0+")
    public String test1Version3Plus() {
        return "test1_3.0+";
    }
    // the explicit request param should not be specified: the attempt to use it for versioning fails
    @GetMapping(path = "/test2")
    public String testExplicitparam(@RequestParam("version_query_param") String reqparam) {
        return "explicit request param: " + reqparam;
    }
    // Invalid API version formats:
    /*@GetMapping(path = "/test1", version = "4.0++")
    public String test1Version4PlusPlus() {
        return "test1_4.0++";
    }
    @GetMapping(path = "/test1", version = "4.0*")
    public String test1Version4Star() {
        return "test1_4.0*";
    }

    @GetMapping(path = "/test1", version = "3.0.0 RELEASE")
    public String test1VersionWithLetters() {
        return "with letters";
    }*/
}
