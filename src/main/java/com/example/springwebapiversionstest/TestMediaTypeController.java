package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@Profile("mediaType")
@RequestMapping("/mediaType")
class TestMediaTypeController {

    @GetMapping(version = "1.0.0")
    public ResponseEntity<String> testV100() {
        return ResponseEntity.ok("v1.0.0");
    }
    @GetMapping(version = "1.2+")
    public ResponseEntity<String> testV12Plus() {
        return ResponseEntity.ok("v1.2+");
    }

}
