package com.ap.productcatalogservice.rest;

import com.ap.productcatalogservice.config.AppProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final AppProperties properties;

    public HomeController(AppProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/")
    public String getGreeting() {
        return properties.getGreeting();
    }
}
