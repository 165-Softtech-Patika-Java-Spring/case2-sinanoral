package com.patika.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    @GetMapping("test")
    public String test() {
        return "Ok :)";
    }
}
