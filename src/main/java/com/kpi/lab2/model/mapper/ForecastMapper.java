package com.kpi.lab2.model.mapper;

import com.kpi.lab2.model.domain.ForecastDto;
import com.kpi.lab2.model.entity.Forecast;
import org.springframework.stereotype.Component;

@Component
public class ForecastMapper {

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

}
