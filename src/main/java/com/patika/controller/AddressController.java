package com.patika.controller;

import com.patika.business.AddressService;
import com.patika.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("test")
    public ResponseEntity test() {
        return ResponseEntity.ok("Ok :)");
    }


    @GetMapping("{id}")
    public ResponseEntity getAddressById(Long id) {
        return addressService.getById(id);
    }

    @PostMapping("create/address")
    public ResponseEntity createAddress(@RequestBody Address address) {
        return addressService.create(address);
    }
}
