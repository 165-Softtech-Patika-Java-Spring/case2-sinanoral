package com.patika.service;

import com.patika.dao.DistrictDao;
import com.patika.mapper.CityMapper;
import com.patika.mapper.DistrictMapper;
import com.patika.model.District;
import com.patika.model.Neighborhood;
import com.patika.model.request.CreateCityRequest;
import com.patika.model.request.CreateDistrictRequest;
import com.patika.model.request.UpdateDistrictRequest;
import com.patika.model.response.GetNeighborhoodResponse;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DistrictService {
    private final DistrictDao districtDao;
    private final DistrictMapper mapper = Mappers.getMapper(DistrictMapper.class);

    @Autowired
    public DistrictService(DistrictDao districtDao) {
        this.districtDao = districtDao;
    }

    public ResponseEntity<Void> create(CreateDistrictRequest createDistrictRequest) {
        District district = mapper.createDistrictRequestToDistrict(createDistrictRequest);
        districtDao.save(district);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<GetNeighborhoodResponse>> getNeighborhoodsById(Long id) {
        List<Neighborhood> neighborhoods = districtDao.getNeighborhoodsById(id);
        List<GetNeighborhoodResponse> neighborhoodResponses = mapper.neighborhoodToGetNeighborhoodResponse(neighborhoods);
        return ResponseEntity.ok(neighborhoodResponses);
    }

    public District getById(Long id) {
        return districtDao.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
}
