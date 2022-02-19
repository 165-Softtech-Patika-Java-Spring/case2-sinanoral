package com.patika.mapper;

import com.patika.model.City;
import com.patika.model.District;
import com.patika.model.request.CreateCityRequest;
import com.patika.model.response.GetCityResponse;
import com.patika.model.response.GetDistrictResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityMapper {
    GetCityResponse countryToGetCountryResponse(City city);

    City createCityRequestToCity(CreateCityRequest createCityRequest);

    List<GetDistrictResponse> districtToGetDistrictResponse(List<District> districts);
}
