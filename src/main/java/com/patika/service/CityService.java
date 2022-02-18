package com.patika.service;

import com.patika.dao.CityDao;
import com.patika.mapper.AddressMapper;
import com.patika.mapper.CityMapper;
import com.patika.model.City;
import com.patika.model.Country;
import com.patika.model.District;
import com.patika.model.Neighborhood;
import com.patika.model.request.CreateCityRequest;
import com.patika.model.request.CreateCountryRequest;
import com.patika.model.response.GetCityResponse;
import com.patika.model.response.GetCountryResponse;
import com.patika.model.response.GetDistrictResponse;
import com.patika.model.response.GetNeighborhoodResponse;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CityService {

    private final CityDao cityDao;
    private final CityMapper mapper = Mappers.getMapper(CityMapper.class);

    @Autowired
    public CityService(CityDao cityDao) {
        this.cityDao = cityDao;
    }

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

    public ResponseEntity<List<GetDistrictResponse>> getDistrictsById(Long id) {
        List<District> districts = cityDao.getDistrictsById(id);
        List<GetDistrictResponse> districtResponses = mapper.districtToGetDistrictResponse(districts);
        return ResponseEntity.ok(districtResponses);
    }

    public City getById(Long id) {
        return cityDao.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
}
