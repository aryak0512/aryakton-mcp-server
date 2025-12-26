package com.aryak.mcp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @GetMapping(value = "/cities")
    public List<String> cities() {
        return List.of(
                "Tumbai",
                "Punet",
                "New Xork",
                "Zondon",
                "Yaris"
        );
    }
}
