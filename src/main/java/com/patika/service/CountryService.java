package com.patika.service;

import com.patika.dao.CountryDao;
import com.patika.mapper.CountryMapper;
import com.patika.model.Country;
import com.patika.model.request.CreateCountryRequest;
import com.patika.model.response.GetCountryResponse;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CountryService {

    private final CountryDao countryDao;
    private final CountryMapper mapper = Mappers.getMapper(CountryMapper.class);

    @Autowired
    public CountryService(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    public ResponseEntity<Void> create(CreateCountryRequest createCountryRequest) {
        Country country = mapper.createCountryRequestToCountry(createCountryRequest);
        countryDao.save(country);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<GetCountryResponse> getByCode(String code) {
        Country country = countryDao.getByCode(code);
        GetCountryResponse getCountryResponse = mapper.countryToGetCountryResponse(country);
        return ResponseEntity.ok(getCountryResponse);
    }

    public Country getById(Long id) {
        return countryDao.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
}
