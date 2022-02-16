package com.patika.business;

import com.patika.dao.AddressDao;
import com.patika.model.Address;
import com.patika.model.response.GetAddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
public class AddressService {

    private final AddressDao addressDao;

    @Autowired
    public AddressService(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public ResponseEntity create(Address address) {
        addressDao.save(address);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<GetAddressResponse> getById(Long id) {
        Address address = addressDao.findById(id).orElse(null);

        if(address == null) {
            throw new NotFoundException("Not Found!");
        }

        GetAddressResponse addressResponse = new GetAddressResponse();
        addressResponse.setCity(address.getCity().getName() + " " + address.getCity().getCode());
        addressResponse.setCountry(address.getCountry().getName() + " " + address.getCountry().getCode());
        addressResponse.setDistrict(address.getDistrict().getName());

        return ResponseEntity.ok(addressResponse);
    }
}
