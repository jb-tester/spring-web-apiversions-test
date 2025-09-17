package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@Profile("multiple")
@RequestMapping("/multiple")
class TestMultipleVersionProvidersController {

    @GetMapping(version = "1.0.0")
    public ResponseEntity<String> testV100() {
        return ResponseEntity.ok("v1.0.0");
    }
    @GetMapping(version = "1.2+")
    public ResponseEntity<String> testV12Plus() {
        return ResponseEntity.ok("v1.2+");
    }
    // duplicates the previous:
    //@GetMapping(version = "1.2.0")
    public ResponseEntity<String> testV120() {
        return ResponseEntity.ok("v1.2.0");
    }

    @GetMapping(version = "1.2.5")
    public ResponseEntity<String> testV125() {
        return ResponseEntity.ok("v1.2.5");
    }

}
