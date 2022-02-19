package com.patika.mapper;

import com.patika.model.District;
import com.patika.model.Neighborhood;
import com.patika.model.request.CreateDistrictRequest;
import com.patika.model.response.GetNeighborhoodResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DistrictMapper {
    District createDistrictRequestToDistrict(CreateDistrictRequest createDistrictRequest);

    List<GetNeighborhoodResponse> neighborhoodToGetNeighborhoodResponse(List<Neighborhood> neighborhoods);
}
