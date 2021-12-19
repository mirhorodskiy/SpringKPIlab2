package com.kpi.lab2.model.service;

import com.kpi.lab2.model.entity.Forecast;
import com.kpi.lab2.model.exception.CityIsNotExistsException;
import com.kpi.lab2.model.exception.DateIsNotExistsException;
import com.kpi.lab2.model.exception.ForecastIsNotExistsException;
import com.kpi.lab2.model.repository.DateRepository;
import com.kpi.lab2.model.repository.ForecastRepository;
import com.kpi.lab2.model.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForecastService {

    ForecastRepository forecastRepository;
    DateRepository dateRepository;
    LocationRepository locationRepository;

    @Autowired
    public ForecastService(ForecastRepository forecastRepository,
                           DateRepository dateRepository,
                           LocationRepository locationRepository) {
        this.forecastRepository = forecastRepository;
        this.dateRepository = dateRepository;
        this.locationRepository = locationRepository;
    }

    public Forecast getForecast(String cityTitle, int day, String month, int year)
            throws CityIsNotExistsException, DateIsNotExistsException, ForecastIsNotExistsException {
        if (!locationRepository.existsByCityTitle(cityTitle)) {
            throw new CityIsNotExistsException("Wrong city title or data is unavailable!");
        }

        if (!dateRepository.existsByDayAndMonthAndYear((byte) day, month, year)) {
            throw new DateIsNotExistsException("Wrong date or there are no data!");
        }

        Forecast forecast = forecastRepository.findByLocationAndDate(locationRepository.findByCityTitle(cityTitle).getId(),
                dateRepository.findByDayAndMonthAndYear((byte) day, month, year).getId());
        if (forecast == null) {
            throw new ForecastIsNotExistsException("There are no forecast for that date!");
        }
        return forecast;
    }

    public void removeForecast(String cityTitle, int day, String month, int year) throws ForecastIsNotExistsException, DateIsNotExistsException, CityIsNotExistsException {
        forecastRepository.delete(getForecast(cityTitle, day, month, year));
    }
}