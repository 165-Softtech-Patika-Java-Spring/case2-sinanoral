package com.patika.service;

import com.patika.dao.NeighborhoodDao;
import com.patika.mapper.NeighborhoodMapper;
import com.patika.model.Neighborhood;
import com.patika.model.request.CreateNeighborhoodRequest;
import com.patika.model.request.UpdateNeighborhoodRequest;
import com.patika.model.response.GetNeighborhoodResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NeighborhoodService {

    private final NeighborhoodDao neighborhoodDao;
    private final NeighborhoodMapper mapper;

    public ResponseEntity<Void> create(CreateNeighborhoodRequest createNeighborhoodRequest) {
        Neighborhood neighborhood = mapper.createNeighborhoodRequestToNeighborhood(createNeighborhoodRequest);
        neighborhoodDao.save(neighborhood);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Void> updateNameById(UpdateNeighborhoodRequest updateNeighborhoodRequest) {
        neighborhoodDao.setNeighborhoodNameById(updateNeighborhoodRequest.getName(), updateNeighborhoodRequest.getId());
        return ResponseEntity.ok().build();
    }

    public Neighborhood getById(Long id) {
        return neighborhoodDao.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    public ResponseEntity<List<GetNeighborhoodResponse>> getNeighborhoodsByDistrictId(Long id) {
        List<Neighborhood> neighborhoods = neighborhoodDao.getNeighborhoodsByDistrict_Id(id);
        List<GetNeighborhoodResponse> neighborhoodResponses = mapper.neighborhoodListToGetNeighborhoodResponseList(neighborhoods);
        return ResponseEntity.ok(neighborhoodResponses);
    }
}
