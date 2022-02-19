package com.patika.service;

import com.patika.dao.CityDao;
import com.patika.mapper.CityMapper;
import com.patika.model.City;
import com.patika.model.request.CreateCityRequest;
import com.patika.model.response.GetCityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityDao cityDao;
    private final CityMapper mapper;

    public ResponseEntity<Void> create(CreateCityRequest createCityRequest) {
        City city = mapper.createCityRequestToCity(createCityRequest);
        cityDao.save(city);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<GetCityResponse> getByPlateNo(String plateNo) {
        City city = cityDao.getByPlateNo(plateNo);
        GetCityResponse getCityResponse = mapper.countryToGetCountryResponse(city);
        return ResponseEntity.ok(getCityResponse);
    }

    public City getById(Long id) {
        return cityDao.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
}
