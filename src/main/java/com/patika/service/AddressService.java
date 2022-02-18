package com.patika.service;

import com.patika.dao.AddressDao;
import com.patika.mapper.AddressMapper;
import com.patika.model.Address;
import com.patika.model.request.CreateAddressRequest;
import com.patika.model.response.GetAddressResponse;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AddressService {

    private final AddressDao addressDao;
    private final AddressMapper mapper = Mappers.getMapper(AddressMapper.class);

    @Autowired
    public AddressService(AddressDao addressDao) {
        this.addressDao = addressDao;

    }

    public ResponseEntity<Void> create(CreateAddressRequest createAddressRequest) {
        Address address = mapper.createAddressRequestToAddress(createAddressRequest);
        addressDao.save(address);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<GetAddressResponse>> getAll() {
        List<Address> addresses = addressDao.findAll();
        List<GetAddressResponse> getAddressResponseList = mapper.addressListToGetAddressResponseList(addresses);
        return ResponseEntity.ok(getAddressResponseList);
    }

    public ResponseEntity<GetAddressResponse> getById(Long id) {
        Address address = addressDao.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
        GetAddressResponse getAddressResponse = mapper.addressToGetAddressResponse(address);
        return ResponseEntity.ok(getAddressResponse);
    }

    public ResponseEntity<Long> deleteById(Long id) {
        addressDao.deleteById(id);
        return ResponseEntity.ok(id);
    }
}
