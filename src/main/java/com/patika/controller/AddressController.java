package com.patika.controller;

import com.patika.model.request.*;
import com.patika.model.response.*;
import com.patika.service.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AddressController {

    private final AddressService addressService;
    private final CountryService countryService;
    private final CityService cityService;
    private final DistrictService districtService;
    private final StreetService streetService;
    private final NeighborhoodService neighborhoodService;

    @Operation(summary = "gets all the addresses", tags = {"addresses"})
    @GetMapping("/addresses")
    public ResponseEntity<List<GetAddressResponse>> getAll() {
        return addressService.getAll();
    }

    @Operation(summary = "gets an address by id", tags = {"addresses"})
    @GetMapping("/addresses/{id}")
    public ResponseEntity<GetAddressResponse> getAddressById(@PathVariable Long id) {
        return addressService.getById(id);
    }

    @Operation(summary = "creates an address", tags = {"addresses"})
    @PostMapping("/addresses")
    public ResponseEntity<Void> createAddress(@RequestBody CreateAddressRequest address) {
        return addressService.create(address);
    }

    @Operation(summary = "deletes an address by id", tags = {"addresses"})
    @DeleteMapping("/addresses/{id}")
    public ResponseEntity<Long> deleteAddressById(@PathVariable Long id) {
        return addressService.deleteById(id);
    }

    @Operation(summary = "creates a country", tags = {"countries"})
    @PostMapping("/countries")
    public ResponseEntity<Void> createCountry(@RequestBody CreateCountryRequest createCountryRequest) {
        return countryService.create(createCountryRequest);
    }

    @Operation(summary = "gets a country by code", tags = {"countries"})
    @GetMapping("/countries/{code}")
    public ResponseEntity<GetCountryResponse> getCountryByCode(@PathVariable String code) {
        return countryService.getByCode(code);
    }

    @Operation(summary = "creates a city", tags = {"cities"})
    @PostMapping("/cities")
    public ResponseEntity<Void> createCity(@RequestBody CreateCityRequest createCityRequest) {
        return cityService.create(createCityRequest);
    }

    @Operation(summary = "gets a city by plate number", tags = {"cities"})
    @GetMapping("/cities/{plateNo}")
    public ResponseEntity<GetCityResponse> getCityByPlateNo(@PathVariable String plateNo) {
        return cityService.getByPlateNo(plateNo);
    }

    @Operation(summary = "gets districts of a city by city id", tags = {"cities"})
    @GetMapping("/cities/{id}/districts")
    public ResponseEntity<List<GetDistrictResponse>> getDistrictsByCityId(@PathVariable Long id) {
        return districtService.getDistrictsByCityId(id);
    }

    @Operation(summary = "creates a district", tags = {"districts"})
    @PostMapping("/districts")
    public ResponseEntity<Void> createDistrict(@RequestBody CreateDistrictRequest createDistrictRequest) {
        return districtService.create(createDistrictRequest);
    }

    @Operation(summary = "gets neighborhoods of a district by district id", tags = {"districts"})
    @GetMapping("/districts/{id}/neighborhoods")
    public ResponseEntity<List<GetNeighborhoodResponse>> getNeighborhoodsByDistrictId(@PathVariable Long id) {
        return neighborhoodService.getNeighborhoodsByDistrictId(id);
    }

    @Operation(summary = "creates a neighborhood", tags = {"neighborhoods"})
    @PostMapping("/neighborhoods")
    public ResponseEntity<Void> createDistrict(@RequestBody CreateNeighborhoodRequest createNeighborhoodRequest) {
        return neighborhoodService.create(createNeighborhoodRequest);
    }

    @Operation(summary = "updates name of a neighborhood by id", tags = {"neighborhoods"})
    @PutMapping("/neighborhoods")
    public ResponseEntity<Void> updateNeighborhoodNameById(@RequestBody UpdateNeighborhoodRequest updateNeighborhoodRequest) {
        return neighborhoodService.updateNameById(updateNeighborhoodRequest);
    }

    @Operation(summary = "gets streets of a neighborhood by neighborhood id", tags = {"neighborhoods"})
    @GetMapping("/neighborhoods/{id}/streets")
    public ResponseEntity<List<GetStreetResponse>> getStreetsByNeighborhoodId(@PathVariable Long id) {
        return streetService.getStreetsByNeighborhoodId(id);
    }

    @Operation(summary = "creates a street", tags = {"streets"})
    @PostMapping("/streets")
    public ResponseEntity<Void> createStreet(@RequestBody CreateStreetRequest createStreetRequest) {
        return streetService.create(createStreetRequest);
    }

    @Operation(summary = "updates name of a street by id", tags = {"streets"})
    @PutMapping("/street")
    public ResponseEntity<Void> updateCityNameById(@RequestBody UpdateStreetRequest updateStreetRequest) {
        return streetService.updateNameById(updateStreetRequest);
    }
}
