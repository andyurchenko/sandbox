package it.sevenbits.courses.testing.practice.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping
    public ResponseEntity<String> printHelloWorld() {
        return ResponseEntity.ok("Hello, World!11");
    }
}
