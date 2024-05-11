package com.ajaycodes.soapws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/test")
    String healthCheck() {
        return "API is working fine";
    }
}
