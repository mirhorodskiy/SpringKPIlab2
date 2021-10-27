package com.kpi.lab2.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ForecastWrapper {

    DateDto dateDto;

    ForecastDto forecastDto;

    LocationDto locationDto;

}
