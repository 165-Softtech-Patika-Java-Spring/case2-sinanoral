package com.patika.service;

import com.patika.dao.CityDao;
import com.patika.dao.NeighborhoodDao;
import com.patika.mapper.CityMapper;
import com.patika.mapper.NeighborhoodMapper;
import com.patika.model.City;
import com.patika.model.District;
import com.patika.model.Neighborhood;
import com.patika.model.Street;
import com.patika.model.request.CreateCityRequest;
import com.patika.model.request.CreateNeighborhoodRequest;
import com.patika.model.request.UpdateDistrictRequest;
import com.patika.model.request.UpdateNeighborhoodRequest;
import com.patika.model.response.GetNeighborhoodResponse;
import com.patika.model.response.GetStreetResponse;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class NeighborhoodService {

    private final NeighborhoodDao neighborhoodDao;
    private final NeighborhoodMapper mapper = Mappers.getMapper(NeighborhoodMapper.class);

    @Autowired
    public NeighborhoodService(NeighborhoodDao neighborhoodDao) {
        this.neighborhoodDao = neighborhoodDao;
    }

    public ResponseEntity<Void> create(CreateNeighborhoodRequest createNeighborhoodRequest) {
        Neighborhood neighborhood = mapper.createNeighborhoodRequestToNeighborhood(createNeighborhoodRequest);
        neighborhoodDao.save(neighborhood);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> updateNameById(UpdateNeighborhoodRequest updateNeighborhoodRequest) {
        neighborhoodDao.setNeighborhoodNameById(updateNeighborhoodRequest.getName(), updateNeighborhoodRequest.getId());
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<GetStreetResponse>> getStreetsById(Long id) {
        List<Street> streets = neighborhoodDao.getStreetsById(id);
        List<GetStreetResponse> streetResponses = mapper.streetToGetStreetResponse(streets);
        return ResponseEntity.ok(streetResponses);
    }

    public Neighborhood getById(Long id) {
        return neighborhoodDao.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
}
