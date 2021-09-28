package com.kpi.lab2.model.service;

import com.kpi.lab2.model.domain.DateDto;
import com.kpi.lab2.model.domain.ForecastDto;
import com.kpi.lab2.model.domain.ForecastWrapper;
import com.kpi.lab2.model.domain.LocationDto;
import com.kpi.lab2.model.entity.Date;
import com.kpi.lab2.model.entity.Forecast;
import com.kpi.lab2.model.entity.Location;
import com.kpi.lab2.model.mapper.DateMapper;
import com.kpi.lab2.model.mapper.ForecastMapper;
import com.kpi.lab2.model.mapper.ForecastWrapperMapper;
import com.kpi.lab2.model.mapper.LocationMapper;
import com.kpi.lab2.model.repository.DateRepository;
import com.kpi.lab2.model.repository.ForecastRepository;
import com.kpi.lab2.model.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    DateRepository dateRepository;
    LocationRepository locationRepository;
    ForecastRepository forecastRepository;
    //ForecastWrapperMapper forecastWrapperMapper;
    DateMapper dateMapper;
    ForecastMapper forecastMapper;
    LocationMapper locationMapper;

    @Autowired
    public AdminService(DateRepository dateRepository, LocationRepository locationRepository,
                        ForecastRepository forecastRepository, DateMapper dateMapper,
                        ForecastMapper forecastMapper, LocationMapper locationMapper) {
        this.dateRepository = dateRepository;
        this.locationRepository = locationRepository;
        this.forecastRepository = forecastRepository;
        this.dateMapper = dateMapper;
        this.forecastMapper = forecastMapper;
        this.locationMapper = locationMapper;
    }


    private Date addDate(DateDto dateDto) {
        Date date = dateMapper.dateDtoToEntity(dateDto);
        return dateRepository.save(date);
    }

    private Location addLocation(LocationDto locationDto) {
        Location location = locationMapper.locationDtoToEntity(locationDto);
        return locationRepository.save(location);
    }

    private Forecast addForecast(ForecastDto forecastDto) {
        Forecast forecast = forecastMapper.forecastDtoToEntity(forecastDto);
        return forecastRepository.save(forecast);
    }


    public ForecastDto addForecastWithLocationAndDate(ForecastWrapper forecastWrapper) {


//        Date date = forecastWrapperMapper.dateDtoToEntity(forecastWrapper.getDate());
//
//        Location location = forecastWrapperMapper.locationDtoToEntity(forecastWrapper.getLocationDto());
//
//        Forecast forecast = forecastWrapperMapper.forecastDtoToEntity(forecastWrapper.getForecastDto());

        Date date = dateRepository.findByDayAndMonthAndYear(forecastWrapper.getDate().getDay(),
                forecastWrapper.getDate().getMonth(), forecastWrapper.getDate().getYear());
        if (date == null) {
            date = addDate(forecastWrapper.getDate());
        }

        Location location = locationRepository.findByCityTitleAndRegion(forecastWrapper.getLocationDto().getCityTitle(),
                forecastWrapper.getLocationDto().getRegion());
        if (location == null) {
            location = addLocation(forecastWrapper.getLocationDto());
        }

        Forecast forecast = forecastRepository.findByLocationAndDate(location.getId(), date.getId());
        if (forecast == null) {
            forecast = addForecast(forecastWrapper.getForecastDto());
        }


        forecast.setDate(date);
        forecast.setLocation(location);

        location.getForecastSet().add(forecast);

        date.getForecastSet().add(forecast);

        dateRepository.save(date);
        locationRepository.save(location);
        forecastRepository.save(forecast);
        System.out.println("forecast saved");

        return forecastWrapper.getForecastDto();
    }
}
