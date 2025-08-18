package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Profile("requestHeaderSupportedVersions")
@RequestMapping("/limitedVersions")
class TestSupportedVersionsController {
  // supported versions: "1.2.0", "1.4", "1.5.0", "2"
    @GetMapping(version = "1.1")
    public String v11() {
        return "v1.1";
    }
    @GetMapping(version = "1.2.0")
    public String v12() {
        return "v1.2.0";
    }
    @GetMapping(version = "1.4")
    public String v14() {
        return "v1.4";
    }
    @GetMapping(version = "1.4.1")
    public String v141() {
        return "v1.4.1";
    }
    @GetMapping(version = "2.0+")
    public String v20Plus() {
        return "v2.0+";
    }

    @GetMapping(version = "2+")
    public String v2plus() {
        return "v2+";
    }

    @GetMapping(version = "2.1")
    public String v21() {
        return "v2.1";
    }
}
