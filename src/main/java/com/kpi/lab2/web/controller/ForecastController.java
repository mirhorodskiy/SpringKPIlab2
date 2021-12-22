package com.kpi.lab2.web.controller;

import com.kpi.lab2.model.entity.Forecast;
import com.kpi.lab2.model.exception.CityIsNotExistsException;
import com.kpi.lab2.model.exception.DateIsNotExistsException;
import com.kpi.lab2.model.exception.ForecastIsNotExistsException;
import com.kpi.lab2.model.service.ForecastService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Forecast", description = "User controller, show forecast")
@RestController
@RequestMapping("/forecast")
public class ForecastController {

    ForecastService forecastService;

    @Autowired
    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @Operation(summary = "Get forecast by city, day, month, year params", tags = "Forecast",
            description = "This method returns  forecast by users city, day, month and year request params. " +
                    "Return forecast with 200 status code or error with status code 400 if some data was wrong")
    @GetMapping()
    public Forecast getForecast(@RequestParam String cityTitle,
                                @RequestParam int day,
                                @RequestParam String month,
                                @RequestParam int year)
            throws ForecastIsNotExistsException, DateIsNotExistsException, CityIsNotExistsException {

        return forecastService.getForecast(cityTitle, day, month, year);

    }


}
