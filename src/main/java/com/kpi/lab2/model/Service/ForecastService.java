package com.kpi.lab2.model.Service;

import com.kpi.lab2.model.repository.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForecastService {

    ForecastRepository forecastRepository;

    @Autowired
    public ForecastService(ForecastRepository forecastRepository) {
        this.forecastRepository = forecastRepository;
    }
}
