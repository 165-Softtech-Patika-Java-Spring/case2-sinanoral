package com.patika.mapper;

import com.patika.model.Street;
import com.patika.model.request.CreateStreetRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StreetMapper {
    Street createStreetRequestToStreet(CreateStreetRequest createStreetRequest);
}
