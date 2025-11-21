package com.cars.cars.web.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class carsController {
    
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello world!" + name.toUpperCase();
    }
    
}
