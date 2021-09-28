package com.kpi.lab2.model.mapper;

import com.kpi.lab2.model.domain.DateDto;
import com.kpi.lab2.model.domain.ForecastDto;
import com.kpi.lab2.model.domain.LocationDto;
import com.kpi.lab2.model.entity.Date;
import com.kpi.lab2.model.entity.Forecast;
import com.kpi.lab2.model.entity.Location;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class ForecastWrapperMapper {

    public Date dateDtoToEntity(DateDto dateDto) {

        if(dateDto == null)
            return null;
        System.out.println("date building");
        return  Date.builder()
                .day(dateDto.getDay())
                .month(dateDto.getMonth())
                .year(dateDto.getYear())
                .forecastSet(new HashSet<>())
                .build();
    }

    public Forecast forecastDtoToEntity(ForecastDto forecastDto) {

        if(forecastDto == null)
            return null;
        System.out.println("forecast building");
        return Forecast.builder()
                .temperature(forecastDto.getTemperature())
                .rainChance(forecastDto.getRainChance())
                .description(forecastDto.getDescription())
                .build();
    }

    public Location locationDtoToEntity(LocationDto locationDto) {

        if (locationDto == null)
            return null;
        System.out.println("location building");
        return Location.builder()
                .cityTitle(locationDto.getCityTitle())
                .region(locationDto.getRegion())
                .forecastSet(new HashSet<>())
                .build();
    }

}
