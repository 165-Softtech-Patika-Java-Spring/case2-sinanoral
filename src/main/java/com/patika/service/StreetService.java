package com.patika.service;

import com.patika.dao.StreetDao;
import com.patika.mapper.StreetMapper;
import com.patika.model.Street;
import com.patika.model.request.CreateStreetRequest;
import com.patika.model.request.UpdateStreetRequest;
import com.patika.model.response.GetStreetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StreetService {
    private final StreetDao streetDao;
    private final StreetMapper mapper;

    public ResponseEntity<Void> create(CreateStreetRequest createStreetRequest) {
        Street street = mapper.createStreetRequestToStreet(createStreetRequest);
        streetDao.save(street);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Void> updateNameById(UpdateStreetRequest updateStreetRequest) {
        streetDao.setStreetNameById(updateStreetRequest.getName(), updateStreetRequest.getId());
        return ResponseEntity.ok().build();
    }

    public Street getById(Long id) {
        return streetDao.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    public ResponseEntity<List<GetStreetResponse>> getStreetsByNeighborhoodId(Long id) {
        List<Street> streets = streetDao.getStreetsByNeighborhood_Id(id);
        List<GetStreetResponse> streetResponses = mapper.streetListToGetStreetResponseList(streets);
        return ResponseEntity.ok(streetResponses);
    }
}
