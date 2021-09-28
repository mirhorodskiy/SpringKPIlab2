package com.kpi.lab2.model.mapper;

import com.kpi.lab2.model.domain.LocationDto;
import com.kpi.lab2.model.entity.Location;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class LocationMapper {

    public Location locationDtoToEntity(LocationDto locationDto) {

        if (locationDto == null)
            return null;
        return Location.builder()
                .cityTitle(locationDto.getCityTitle())
                .region(locationDto.getRegion())
                .forecastSet(new HashSet<>())
                .build();
    }

}
