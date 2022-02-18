package com.patika.mapper;

import com.patika.model.Neighborhood;
import com.patika.model.Street;
import com.patika.model.request.CreateNeighborhoodRequest;
import com.patika.model.response.GetStreetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NeighborhoodMapper {
    Neighborhood createNeighborhoodRequestToNeighborhood(CreateNeighborhoodRequest createNeighborhoodRequest);

    List<GetStreetResponse> streetToGetStreetResponse(List<Street> streets);
}
