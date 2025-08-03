package com.example.springwebapiversionstest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/test")
class TestController {

    @GetMapping(version = "1.0.0")
    public String testExplicitlySpecifiedDefaultVersion() {
        return "test Explicitly Specified Default Version";
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
}
