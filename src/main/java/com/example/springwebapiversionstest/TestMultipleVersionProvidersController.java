package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@Profile("multiple")
@RequestMapping("/multiple")
class TestMultipleVersionProvidersController {

}
