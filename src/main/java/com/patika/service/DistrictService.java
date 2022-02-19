package com.patika.service;

import com.patika.dao.DistrictDao;
import com.patika.mapper.DistrictMapper;
import com.patika.model.District;
import com.patika.model.request.CreateDistrictRequest;
import com.patika.model.response.GetDistrictResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictService {
    private final DistrictDao districtDao;
    private final DistrictMapper mapper;

    public ResponseEntity<Void> create(CreateDistrictRequest createDistrictRequest) {
        District district = mapper.createDistrictRequestToDistrict(createDistrictRequest);
        districtDao.save(district);
        return ResponseEntity.ok().build();
    }

    public District getById(Long id) {
        return districtDao.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    public ResponseEntity<List<GetDistrictResponse>> getDistrictsByCityId(Long id) {
        List<District> districts = districtDao.getDistrictsByCityId(id);
        List<GetDistrictResponse> districtResponses = mapper.districtListToGetDistrictResponseList(districts);
        return ResponseEntity.ok(districtResponses);
    }
}
