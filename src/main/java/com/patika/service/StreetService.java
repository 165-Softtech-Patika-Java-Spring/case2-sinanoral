package com.patika.service;

import com.patika.dao.StreetDao;
import com.patika.mapper.StreetMapper;
import com.patika.model.District;
import com.patika.model.Neighborhood;
import com.patika.model.Street;
import com.patika.model.request.CreateNeighborhoodRequest;
import com.patika.model.request.CreateStreetRequest;
import com.patika.model.request.UpdateDistrictRequest;
import com.patika.model.request.UpdateStreetRequest;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class StreetService {
    private final StreetDao streetDao;
    private final StreetMapper mapper = Mappers.getMapper(StreetMapper.class);

    public StreetService(StreetDao streetDao) {
        this.streetDao = streetDao;
    }

    public ResponseEntity<Void> create(CreateStreetRequest createStreetRequest) {
        Street street = mapper.createStreetRequestToStreet(createStreetRequest);
        streetDao.save(street);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> updateNameById(UpdateStreetRequest updateStreetRequest) {
        streetDao.setStreetNameById(updateStreetRequest.getName(), updateStreetRequest.getId());
        return ResponseEntity.ok().build();
    }

    public Street getById(Long id) {
        return streetDao.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

}
