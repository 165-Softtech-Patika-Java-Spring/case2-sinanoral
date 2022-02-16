package com.patika.model.response;

import lombok.Data;

@Data
public class GetAddressResponse {
    private Long id;
    private String country;
    private String city;
    private String district;
    private String neighborhood;
    private String street;
    private String buildingNo;
    private String apartmentNo;
}
