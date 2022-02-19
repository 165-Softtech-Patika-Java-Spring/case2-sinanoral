package com.patika.controller;

import com.patika.model.request.*;
import com.patika.model.response.*;
import com.patika.service.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private final AddressService addressService;
    private final CountryService countryService;
    private final CityService cityService;
    private final DistrictService districtService;
    private final StreetService streetService;
    private final NeighborhoodService neighborhoodService;

    @Autowired
    public AddressController(AddressService addressService, CountryService countryService, CityService cityService, DistrictService districtService, StreetService streetService, NeighborhoodService neighborhoodService) {
        this.addressService = addressService;
        this.countryService = countryService;
        this.cityService = cityService;
        this.districtService = districtService;
        this.streetService = streetService;
        this.neighborhoodService = neighborhoodService;
    }

    @Operation(summary = "gets all the addresses", tags = {"address"})
    @GetMapping
    public ResponseEntity<List<GetAddressResponse>> getAll() {
        return addressService.getAll();
    }

    @Operation(summary = "gets an address by id", tags = {"address"})
    @GetMapping("/{id}")
    public ResponseEntity<GetAddressResponse> getAddressById(@PathVariable Long id) {
        return addressService.getById(id);
    }

    @Operation(summary = "creates an address", tags = {"address"})
    @PostMapping
    public ResponseEntity<Void> createAddress(@RequestBody CreateAddressRequest address) {
        return addressService.create(address);
    }

    @Operation(summary = "deletes an addresses by id", tags = {"address"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteAddressById(@PathVariable Long id) {
        return addressService.deleteById(id);
    }

    @Operation(summary = "creates a country", tags = {"countries"})
    @PostMapping("/country")
    public ResponseEntity<Void> createCountry(@RequestBody CreateCountryRequest createCountryRequest) {
        return countryService.create(createCountryRequest);
    }

    @Operation(summary = "gets a country by code", tags = {"countries"})
    @GetMapping("/countries/{code}")
    public ResponseEntity<GetCountryResponse> getCountryByCode(@PathVariable String code) {
        return countryService.getByCode(code);
    }

    @Operation(summary = "creates a city", tags = {"cities"})
    @PostMapping("/city")
    public ResponseEntity<Void> createCity(@RequestBody CreateCityRequest createCityRequest) {
        return cityService.create(createCityRequest);
    }

    @Operation(summary = "gets a city by plate number", tags = {"cities"})
    @GetMapping("/cities/{plateNo}")
    public ResponseEntity<GetCityResponse> getCityByPlateNo(@PathVariable String plateNo) {
        return cityService.getByPlateNo(plateNo);
    }

    @Operation(summary = "gets districts of a city by city id", tags = {"cities"})
    @GetMapping("/city/{id}/districts")
    public ResponseEntity<List<GetDistrictResponse>> getDistrictsOfCityByCityId(@PathVariable Long id) {
        return cityService.getDistrictsById(id);
    }

    @Operation(summary = "creates a district", tags = {"districts"})
    @PostMapping("/district")
    public ResponseEntity<Void> createDistrict(@RequestBody CreateDistrictRequest createDistrictRequest) {
        return districtService.create(createDistrictRequest);
    }

    @Operation(summary = "gets neighborhoods of a district by district id", tags = {"districts"})
    @GetMapping("/district/{id}/neighborhoods")
    public ResponseEntity<List<GetNeighborhoodResponse>> getNeighborhoodsOfDistrictByDistrictId(@PathVariable Long id) {
        return districtService.getNeighborhoodsById(id);
    }

    @Operation(summary = "creates a neighborhood", tags = {"neighborhood"})
    @PostMapping("/neighborhood")
    public ResponseEntity<Void> createDistrict(@RequestBody CreateNeighborhoodRequest createNeighborhoodRequest) {
        return neighborhoodService.create(createNeighborhoodRequest);
    }

    @Operation(summary = "updates name of a neighborhood by id", tags = {"neighborhood"})
    @PutMapping("/neighborhood")
    public ResponseEntity<Void> updateNeighborhoodNameById(@RequestBody UpdateNeighborhoodRequest updateNeighborhoodRequest) {
        return neighborhoodService.updateNameById(updateNeighborhoodRequest);
    }

    @Operation(summary = "gets streets of a neighborhood by neighborhood id", tags = {"neighborhood"})
    @PutMapping("/neighborhood/{id}/streets")
    public ResponseEntity<List<GetStreetResponse>> updateNeighborhoodNameById(@PathVariable Long id) {
        return neighborhoodService.getStreetsById(id);
    }

    @Operation(summary = "creates a street", tags = {"street"})
    @PostMapping("/street")
    public ResponseEntity<Void> createStreet(@RequestBody CreateStreetRequest createStreetRequest) {
        return streetService.create(createStreetRequest);
    }

    @Operation(summary = "updates name of a street by id", tags = {"street"})
    @PutMapping("/street")
    public ResponseEntity<Void> updateCityNameById(@RequestBody UpdateStreetRequest updateStreetRequest) {
        return streetService.updateNameById(updateStreetRequest);
    }
}
