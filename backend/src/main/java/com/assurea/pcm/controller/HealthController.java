package com.assurea.pcm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/health")
    public String check() {
        return "✅ Spring Boot is running with PostgreSQL!";
    }
}